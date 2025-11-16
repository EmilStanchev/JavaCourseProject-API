// package com.uniproject.unitproject.config;

// import com.uniproject.unitproject.entities.*;
// import com.uniproject.unitproject.repositories.*;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import java.nio.charset.StandardCharsets;
// import java.security.MessageDigest;
// import java.time.Instant;
// import java.util.*;

// @Configuration
// public class DataSeeder {

//     private String hashPassword(String password) {
//         try {
//             MessageDigest digest = MessageDigest.getInstance("SHA-256");
//             byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
//             StringBuilder hexString = new StringBuilder();
//             for (byte b : hash) {
//                 String hex = Integer.toHexString(0xff & b);
//                 if (hex.length() == 1)
//                     hexString.append('0');
//                 hexString.append(hex);
//             }
//             return hexString.toString();
//         } catch (Exception e) {
//             return password;
//         }
//     }

//     @Bean
//     CommandLineRunner initDatabase(
//             UserRepository userRepository,
//             CampsiteRepository campsiteRepository,
//             TripRepository tripRepository,
//             ReviewRepository reviewRepository,
//             LandmarkRepository landmarkRepository,
//             SaleItemRepository saleItemRepository) {

//         return args -> {

//             if (userRepository.count() > 0) {
//                 System.out.println("Database already seeded — skipping.");
//                 return;
//             }

//             System.out.println("🌱 Starting seed...");

//             List<User> users = seedUsers(userRepository);
//             List<Campsite> campsites = seedCampsites(campsiteRepository);
//             List<Landmark> landmarks = seedLandmarks(landmarkRepository, campsites);
//             List<Trip> trips = seedTrips(tripRepository, users, campsites, landmarks);
//             seedReviews(reviewRepository, users, campsites);
//             seedSaleItems(saleItemRepository, users);
//             updateUserRelationships(userRepository, users, trips);

//             System.out.println("🌳 Database seeded successfully.");
//         };
//     }

//     // ───────────────────────────────────────────────────────────────
//     // USERS
//     // ───────────────────────────────────────────────────────────────

//     private List<User> seedUsers(UserRepository repo) {

//         List<User> users = new ArrayList<>();

//         String[][] data = {
//                 { "john@email.com", "john", "USA" },
//                 { "sarah@email.com", "sarah", "Canada" },
//                 { "mike@email.com", "mike", "USA" },
//                 { "emma@email.com", "emma", "UK" },
//                 { "david@email.com", "david", "Australia" },
//         };

//         for (String[] u : data) {
//             User user = new User();
//             user.setEmail(u[0]);
//             user.setUsername(u[1]);
//             user.setPassword(hashPassword("password123"));
//             user.setCountry(u[2]);
//             user.setBudget(5000.0);

//             // VEHICLE
//             Vehicle v = new Vehicle();
//             v.setBrand("Toyota");
//             v.setModel("4Runner");
//             v.setYear(2020);
//             user.setVehicle(v);

//             // EXPENSES
//             Expense e1 = new Expense();
//             e1.setName("Camping Gear Purchase");
//             e1.setAmount(200.0);
//             e1.setCategory("Gear");
//             e1.setNotes("Tent");
//             e1.setCreatedAt(Instant.now());

//             Expense e2 = new Expense();
//             e2.setName("Food Purchase");
//             e2.setAmount(100.0);
//             e2.setCategory("Food");
//             e2.setNotes("Weekend food");
//             e2.setCreatedAt(Instant.now());

//             user.setExpenses(List.of(e1, e2));

//             user.setFavoriteTags(List.of("mountain", "forest", "lake"));

//             users.add(repo.save(user));
//         }

//         return users;
//     }

//     // ───────────────────────────────────────────────────────────────
//     // CAMPSITES
//     // ───────────────────────────────────────────────────────────────

//     private List<Campsite> seedCampsites(CampsiteRepository repo) {

//         List<Campsite> campsites = new ArrayList<>();

//         Campsite c1 = new Campsite();
//         c1.setTitle("Yosemite Valley Campground");
//         c1.setLocation("Yosemite Valley, CA");
//         c1.setDescription("Beautiful views at Yosemite.");
//         c1.setLongDesc("Long description...");
//         c1.setLatitude(37.7489);
//         c1.setLongitude(-119.5874);
//         c1.setCountry("USA");
//         c1.setPlaces(40);
//         c1.setImages(List.of("img1", "img2"));
//         c1.setUtilities(List.of("Water", "Showers", "Picnic Tables"));
//         c1.setTags(List.of("mountain", "forest"));

//         Campsite.Price price1 = new Campsite.Price();
//         price1.setPerNight(35.0);
//         price1.setCurrency("USD");
//         price1.setAdditionalNotes("Reservations required");
//         c1.setPrice(price1);

//         Campsite c2 = new Campsite();
//         c2.setTitle("Two Jack Lakeside");
//         c2.setLocation("Banff, Canada");
//         c2.setDescription("Lake views.");
//         c2.setLongDesc("Long description...");
//         c2.setLatitude(51.2235);
//         c2.setLongitude(-115.5174);
//         c2.setCountry("Canada");
//         c2.setPlaces(50);
//         c2.setImages(List.of("img1", "img2"));
//         c2.setUtilities(List.of("Water", "Fire pits", "Store"));
//         c2.setTags(List.of("lake", "mountain"));

//         Campsite.Price price2 = new Campsite.Price();
//         price2.setPerNight(28.0);
//         price2.setCurrency("CAD");
//         price2.setAdditionalNotes("Discovery Pass required");
//         c2.setPrice(price2);

//         campsites.add(repo.save(c1));
//         campsites.add(repo.save(c2));

//         return campsites;
//     }

//     // ───────────────────────────────────────────────────────────────
//     // LANDMARKS
//     // ───────────────────────────────────────────────────────────────

//     private List<Landmark> seedLandmarks(LandmarkRepository repo, List<Campsite> campsites) {

//         List<Landmark> list = new ArrayList<>();

//         Landmark l1 = new Landmark();
//         l1.setTitle("Half Dome");
//         l1.setDesc("Famous hike in Yosemite.");
//         l1.setLatitude(37.7459);
//         l1.setLongitude(-119.5333);
//         l1.setRating(5);
//         l1.setImages(List.of("img1"));
//         l1.setNearCampsite(campsites.get(0));

//         Landmark l2 = new Landmark();
//         l2.setTitle("Lake Minnewanka");
//         l2.setDesc("Beautiful lake in Banff.");
//         l2.setLatitude(51.25);
//         l2.setLongitude(-115.5);
//         l2.setRating(4);
//         l2.setImages(List.of("img2"));
//         l2.setNearCampsite(campsites.get(1));

//         list.add(repo.save(l1));
//         list.add(repo.save(l2));

//         return list;
//     }

//     // ───────────────────────────────────────────────────────────────
//     // TRIPS
//     // ───────────────────────────────────────────────────────────────

//     private List<Trip> seedTrips(
//             TripRepository repo,
//             List<User> users,
//             List<Campsite> campsites,
//             List<Landmark> landmarks) {

//         List<Trip> list = new ArrayList<>();

//         Trip t = new Trip();
//         t.setTitle("Yosemite Adventure");
//         t.setTag("mountain");
//         t.setDescription("A fun weekend trip.");
//         t.setUser(users.get(0));
//         t.setLikes(0);
//         t.setReviews(new ArrayList<>());
//         t.setStops(List.of(campsites.get(0)));
//         t.setLandmarks(List.of(landmarks.get(0)));
//         t.setTotalDistance(120.5);

//         list.add(repo.save(t));
//         return list;
//     }

//     // ───────────────────────────────────────────────────────────────
//     // REVIEWS
//     // ───────────────────────────────────────────────────────────────

//     private void seedReviews(
//             ReviewRepository repo,
//             List<User> users,
//             List<Campsite> campsites) {

//         Review r = new Review();
//         r.setContent("Amazing place!");
//         r.setStars(5);
//         r.setUser(users.get(0));
//         r.setCampsite(campsites.get(0));

//         repo.save(r);
//     }

//     // ───────────────────────────────────────────────────────────────
//     // SALE ITEMS
//     // ───────────────────────────────────────────────────────────────

//     private void seedSaleItems(SaleItemRepository repo, List<User> users) {

//         SaleItem s = new SaleItem();
//         s.setTitle("Camping Chair");
//         s.setPrice(25.0);
//         s.setDescription("Strong and lightweight.");
//         s.setUser(users.get(1));

//         repo.save(s);
//     }

//     // ───────────────────────────────────────────────────────────────
//     // USER RELATIONSHIPS
//     // ───────────────────────────────────────────────────────────────

//     private void updateUserRelationships(
//             UserRepository repo,
//             List<User> users,
//             List<Trip> trips) {

//         User u = users.get(0);
//         u.setFavoriteTrips(List.of(trips.get(0)));

//         repo.save(u);
//     }
// }
