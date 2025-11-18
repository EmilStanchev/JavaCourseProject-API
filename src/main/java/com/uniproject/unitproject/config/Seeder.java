package com.uniproject.unitproject.config;

import com.uniproject.unitproject.entities.Campsite;
import com.uniproject.unitproject.entities.Landmark;
import com.uniproject.unitproject.entities.Trip;
import com.uniproject.unitproject.entities.User;
import com.uniproject.unitproject.entities.Vehicle;
import com.uniproject.unitproject.repositories.CampsiteRepository;
import com.uniproject.unitproject.repositories.LandmarkRepository;
import com.uniproject.unitproject.repositories.TripRepository;
import com.uniproject.unitproject.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class Seeder {

    @Bean
    public CommandLineRunner seedData(
            UserRepository userRepository,
            CampsiteRepository campsiteRepository,
            LandmarkRepository landmarkRepository,
            TripRepository tripRepository
    ) {
        return args -> {
            // ---------- USERS ----------
            User u1 = new User();
            u1.setEmail("maria@example.com");
            u1.setUsername("maria");
            u1.setPassword("password"); // for seed only
            u1.setCountry("Bulgaria");
            Vehicle v1 = new Vehicle(); v1.setBrand("Toyota"); v1.setModel("RAV4"); v1.setYear(2018);
            u1.setVehicle(v1);

            User u2 = new User();
            u2.setEmail("ivan@example.com");
            u2.setUsername("ivan");
            u2.setPassword("password");
            u2.setCountry("Bulgaria");

            User u3 = new User();
            u3.setEmail("anna@example.com");
            u3.setUsername("anna");
            u3.setPassword("password");
            u3.setCountry("Bulgaria");

            User u4 = new User();
            u4.setEmail("georgi@example.com");
            u4.setUsername("georgi");
            u4.setPassword("password");
            u4.setCountry("Bulgaria");

            User u5 = new User();
            u5.setEmail("petya@example.com");
            u5.setUsername("petya");
            u5.setPassword("password");
            u5.setCountry("Bulgaria");

            userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));

            // Optionally set friends (bidirectional not configured in your model, keep it simple)
            u1.setFriends(Arrays.asList(u2, u3));
            u2.setFriends(Arrays.asList(u1));
            userRepository.saveAll(Arrays.asList(u1, u2));

            // ---------- CAMPSITES ----------
            // Note: images/utilities/tags are simple string lists stored via @ElementCollection.
            Campsite c1 = new Campsite();
            c1.setTitle("Camping Veliko Tarnovo");
            c1.setLocation("Veliko Tarnovo, Bulgaria");
            c1.setDescription("Small family-friendly campsite with pool and terrace views.");
            c1.setLongDesc("Camping Veliko Tarnovo offers terraces, a camper kitchen and is close to the old town.");
            c1.setLatitude(43.0757);
            c1.setLongitude(25.6172);
            c1.setImages(Arrays.asList("https://example.com/images/vt-1.jpg"));
            c1.setUtilities(Arrays.asList("Toilets", "Showers", "Electric hook-ups", "Water"));
            c1.setCountry("Bulgaria");
            Campsite.Price p1 = new Campsite.Price();
            p1.setPerNight(12.5); p1.setCurrency("EUR"); p1.setAdditionalNotes("Price per pitch.");
            c1.setPrice(p1);
            c1.setPlaces(30);
            c1.setTags(Arrays.asList("pool", "family", "near-town"));

            Campsite c2 = new Campsite();
            c2.setTitle("Camping Rila / near Rila Monastery");
            c2.setLocation("Rila Mountains, near Rila Monastery");
            c2.setDescription("Mountain campsite close to Rila Monastery and hiking trails.");
            c2.setLongDesc("Great base for the Rila Monastery and the Seven Rila Lakes.");
            c2.setLatitude(42.1333);
            c2.setLongitude(23.3333);
            c2.setImages(Arrays.asList("https://example.com/images/rila-1.jpg"));
            c2.setUtilities(Arrays.asList("Toilets", "Hiking info", "Fire pits"));
            c2.setCountry("Bulgaria");
            Campsite.Price p2 = new Campsite.Price();
            p2.setPerNight(10.0); p2.setCurrency("EUR"); p2.setAdditionalNotes("Seasonal.");
            c2.setPrice(p2);
            c2.setPlaces(50);
            c2.setTags(Arrays.asList("mountain", "hiking"));

            Campsite c3 = new Campsite();
            c3.setTitle("Shkorpilovtsi Beach Camping");
            c3.setLocation("Shkorpilovtsi, Black Sea coast");
            c3.setDescription("Sandy beach, pine shelter and family facilities.");
            c3.setLongDesc("Popular coastal campsite with direct access to the beach.");
            c3.setLatitude(42.9186);
            c3.setLongitude(27.5450);
            c3.setImages(Arrays.asList("https://example.com/images/shkorp-1.jpg"));
            c3.setUtilities(Arrays.asList("Beach access", "Showers", "Small shop"));
            c3.setCountry("Bulgaria");
            Campsite.Price p3 = new Campsite.Price();
            p3.setPerNight(15.0); p3.setCurrency("EUR"); p3.setAdditionalNotes("High season rates higher.");
            c3.setPrice(p3);
            c3.setPlaces(80);
            c3.setTags(Arrays.asList("beach", "family"));

            Campsite c4 = new Campsite();
            c4.setTitle("Camping Batak (Eco)");
            c4.setLocation("Batak Reservoir area");
            c4.setDescription("Reservoir, fishing and quiet forest pitches.");
            c4.setLongDesc("Eco-focused site near Batak for water sports and hiking.");
            c4.setLatitude(41.9026);
            c4.setLongitude(24.0440);
            c4.setImages(Arrays.asList("https://example.com/images/batak-1.jpg"));
            c4.setUtilities(Arrays.asList("Boat rental", "Fishing platform", "Toilets"));
            c4.setCountry("Bulgaria");
            Campsite.Price p4 = new Campsite.Price();
            p4.setPerNight(9.5); p4.setCurrency("EUR"); p4.setAdditionalNotes("Quiet site.");
            c4.setPrice(p4);
            c4.setPlaces(40);
            c4.setTags(Arrays.asList("lake", "fishing"));

            Campsite c5 = new Campsite();
            c5.setTitle("Koprinka / Rozova Dolina Camping");
            c5.setLocation("Koprinka Dam, Stara Planina");
            c5.setDescription("Dam-side camping with hiking and boating options.");
            c5.setLongDesc("Useful as a gateway to Stara Planina trails.");
            c5.setLatitude(42.6000);
            c5.setLongitude(25.1833);
            c5.setImages(Arrays.asList("https://example.com/images/koprinka-1.jpg"));
            c5.setUtilities(Arrays.asList("Boat rental", "BBQ", "Toilets"));
            c5.setCountry("Bulgaria");
            Campsite.Price p5 = new Campsite.Price();
            p5.setPerNight(11.0); p5.setCurrency("EUR"); p5.setAdditionalNotes("");
            c5.setPrice(p5);
            c5.setPlaces(35);
            c5.setTags(Arrays.asList("dam", "hiking"));

            Campsite c6 = new Campsite();
            c6.setTitle("Alino Lake Camping");
            c6.setLocation("Alino Lake, Bulgaria");
            c6.setDescription("Small lakeside campsite with natural surroundings.");
            c6.setLongDesc("Great for a quiet weekend by the water.");
            c6.setLatitude(42.2500);
            c6.setLongitude(24.7500);
            c6.setImages(Arrays.asList("https://example.com/images/alino-1.jpg"));
            c6.setUtilities(Arrays.asList("Toilets", "Water", "Fire pits"));
            c6.setCountry("Bulgaria");
            Campsite.Price p6 = new Campsite.Price();
            p6.setPerNight(8.0); p6.setCurrency("EUR"); p6.setAdditionalNotes("");
            c6.setPrice(p6);
            c6.setPlaces(20);
            c6.setTags(Arrays.asList("lake", "quiet"));

            Campsite c7 = new Campsite();
            c7.setTitle("7 Lakes Camping (Rila area)");
            c7.setLocation("Rila Mountains - 7 Rila Lakes area");
            c7.setDescription("Base for the famous Seven Rila Lakes hikes.");
            c7.setLongDesc("Popular with hikers wanting early access to the lakes.");
            c7.setLatitude(42.0300);
            c7.setLongitude(23.5000);
            c7.setImages(Arrays.asList("https://example.com/images/7lakes-1.jpg"));
            c7.setUtilities(Arrays.asList("Hiking info", "Shelter"));
            c7.setCountry("Bulgaria");
            Campsite.Price p7 = new Campsite.Price();
            p7.setPerNight(6.0); p7.setCurrency("EUR"); p7.setAdditionalNotes("Simple site.");
            c7.setPrice(p7);
            c7.setPlaces(25);
            c7.setTags(Arrays.asList("mountain", "hiking"));

            Campsite c8 = new Campsite();
            c8.setTitle("Irakli Wild Beach spots");
            c8.setLocation("Irakli Beach, Black Sea coast");
            c8.setDescription("Wild camping area with few facilities; popular for quiet beaches.");
            c8.setLongDesc("Natural beach area; limited services - more wild-style camping.");
            c8.setLatitude(43.2667);
            c8.setLongitude(27.7833);
            c8.setImages(Arrays.asList("https://example.com/images/irakli-1.jpg"));
            c8.setUtilities(Arrays.asList("None - wild camping", "Nearby shops"));
            c8.setCountry("Bulgaria");
            Campsite.Price p8 = new Campsite.Price();
            p8.setPerNight(0.0); p8.setCurrency("EUR"); p8.setAdditionalNotes("Wild camping - free.");
            c8.setPrice(p8);
            c8.setPlaces(0);
            c8.setTags(Arrays.asList("wild", "beach"));

            Campsite c9 = new Campsite();
            c9.setTitle("Shiroka Polyana / Beglika area camping");
            c9.setLocation("Shiroka Polyana Reservoir area");
            c9.setDescription("Forest campsite near Shiroka Polyana resort.");
            c9.setLongDesc("Good for mountain biking and water activities.");
            c9.setLatitude(41.9964);
            c9.setLongitude(24.6339);
            c9.setImages(Arrays.asList("https://example.com/images/shiroka-1.jpg"));
            c9.setUtilities(Arrays.asList("Toilets", "Playground", "Boat rental"));
            c9.setCountry("Bulgaria");
            Campsite.Price p9 = new Campsite.Price();
            p9.setPerNight(10.0); p9.setCurrency("EUR"); p9.setAdditionalNotes("");
            c9.setPrice(p9);
            c9.setPlaces(45);
            c9.setTags(Arrays.asList("reservoir", "family"));

            Campsite c10 = new Campsite();
            c10.setTitle("Camping Veliko (alternative)");
            c10.setLocation("Near Veliko Tarnovo - alternate site");
            c10.setDescription("Smaller campsite with garden terraces.");
            c10.setLongDesc("Good budget option close to Veliko Tarnovo.");
            c10.setLatitude(43.0800);
            c10.setLongitude(25.6200);
            c10.setImages(Arrays.asList("https://example.com/images/vt2-1.jpg"));
            c10.setUtilities(Arrays.asList("Toilets", "Electric"));
            c10.setCountry("Bulgaria");
            Campsite.Price p10 = new Campsite.Price();
            p10.setPerNight(9.0); p10.setCurrency("EUR"); p10.setAdditionalNotes("");
            c10.setPrice(p10);
            c10.setPlaces(20);
            c10.setTags(Arrays.asList("budget", "near-town"));

            List<Campsite> campsites = campsiteRepository.saveAll(
                    Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10)
            );

            // ---------- LANDMARKS ----------
            // Each landmark references a nearby campsite (nearCampsite)
            Landmark l1 = new Landmark();
            l1.setTitle("Rila Monastery");
            l1.setDescription("UNESCO World Heritage monastery, founded in the 10th century.");
            l1.setLatitude(42.1333);
            l1.setLongitude(23.3333);
            l1.setImages(Arrays.asList("https://example.com/images/rila-monastery.jpg"));
            l1.setRating(5);
            l1.setNearCampsite(c2); // campsite near Rila Monastery

            Landmark l2 = new Landmark();
            l2.setTitle("Seven Rila Lakes");
            l2.setDescription("Group of glacial lakes famous for hiking and views.");
            l2.setLatitude(42.0284);
            l2.setLongitude(23.4846);
            l2.setImages(Arrays.asList("https://example.com/images/7lakes.jpg"));
            l2.setRating(5);
            l2.setNearCampsite(c7);

            Landmark l3 = new Landmark();
            l3.setTitle("Tsarevets Fortress");
            l3.setDescription("Medieval stronghold in Veliko Tarnovo.");
            l3.setLatitude(43.0840);
            l3.setLongitude(25.5260);
            l3.setImages(Arrays.asList("https://example.com/images/tsarevets.jpg"));
            l3.setRating(5);
            l3.setNearCampsite(c1);

            Landmark l4 = new Landmark();
            l4.setTitle("Nessebar Old Town");
            l4.setDescription("Historic town on the Black Sea, UNESCO site.");
            l4.setLatitude(42.6575);
            l4.setLongitude(27.7253);
            l4.setImages(Arrays.asList("https://example.com/images/nessebar.jpg"));
            l4.setRating(5);
            l4.setNearCampsite(c3);

            Landmark l5 = new Landmark();
            l5.setTitle("Melnik Pyramids");
            l5.setDescription("Unique sandstone formations near the town of Melnik.");
            l5.setLatitude(41.3929);
            l5.setLongitude(23.2357);
            l5.setImages(Arrays.asList("https://example.com/images/melnik.jpg"));
            l5.setRating(4);
            l5.setNearCampsite(c6);

            Landmark l6 = new Landmark();
            l6.setTitle("Shabla Lighthouse");
            l6.setDescription("Historic lighthouse at the northeasternmost point of Bulgaria.");
            l6.setLatitude(43.5867);
            l6.setLongitude(28.1450);
            l6.setImages(Arrays.asList("https://example.com/images/shabla.jpg"));
            l6.setRating(4);
            l6.setNearCampsite(c8);

            Landmark l7 = new Landmark();
            l7.setTitle("Batak Reservoir");
            l7.setDescription("Reservoir famous for fishing and water sports.");
            l7.setLatitude(41.8939);
            l7.setLongitude(24.0511);
            l7.setImages(Arrays.asList("https://example.com/images/batak-reservoir.jpg"));
            l7.setRating(4);
            l7.setNearCampsite(c4);

            Landmark l8 = new Landmark();
            l8.setTitle("Koprinka Dam");
            l8.setDescription("Dam and lake with beaches and hiking nearby.");
            l8.setLatitude(42.6010);
            l8.setLongitude(25.1820);
            l8.setImages(Arrays.asList("https://example.com/images/koprinka.jpg"));
            l8.setRating(4);
            l8.setNearCampsite(c5);

            Landmark l9 = new Landmark();
            l9.setTitle("Shiroka Polyana Reservoir");
            l9.setDescription("Scenic reservoir popular for summer recreation.");
            l9.setLatitude(41.9964);
            l9.setLongitude(24.6339);
            l9.setImages(Arrays.asList("https://example.com/images/shiroka-res.jpg"));
            l9.setRating(4);
            l9.setNearCampsite(c9);

            Landmark l10 = new Landmark();
            l10.setTitle("Irakli Beach");
            l10.setDescription("A wild, less-developed beach on the Black Sea coast.");
            l10.setLatitude(42.9547);
            l10.setLongitude(27.7850);
            l10.setImages(Arrays.asList("https://example.com/images/irakli.jpg"));
            l10.setRating(4);
            l10.setNearCampsite(c8);

            List<Landmark> landmarks = landmarkRepository.saveAll(
                    Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10)
            );

            // ---------- TRIPS ----------
            // Important: Trip.user is @ManyToOne nullable = false in your model => set user and ensure user is saved first.
            Trip t1 = new Trip();
            t1.setTitle("Rila Explorer");
            t1.setDescription("A short hiking trip visiting Rila Monastery and the Seven Rila Lakes.");
            t1.setLongDesc("Start at Rila Monastery, hike to the Seven Rila Lakes, overnight at nearby campsite.");
            t1.setStops(Arrays.asList(c2, c7)); // campsites (persisted)
            t1.setTag("hiking");
            t1.setLikes(12);
            t1.setUser(u1); // must be persisted already
            t1.setTotalDistance(42.0);
            t1.setLandmarks(Arrays.asList(l1, l2));

            Trip t2 = new Trip();
            t2.setTitle("Veliko Tarnovo Cultural Trip");
            t2.setDescription("Visit Veliko Tarnovo and Tsarevets fortress, stay near town.");
            t2.setLongDesc("History, cobbled streets and terraces.");
            t2.setStops(Arrays.asList(c1, c10));
            t2.setTag("culture");
            t2.setLikes(8);
            t2.setUser(u2);
            t2.setTotalDistance(8.5);
            t2.setLandmarks(Arrays.asList(l3));

            Trip t3 = new Trip();
            t3.setTitle("Black Sea Chill");
            t3.setDescription("Beach camping and old-town Nessebar.");
            t3.setLongDesc("Relaxing coastal camping with a visit to Nessebar.");
            t3.setStops(Arrays.asList(c3, c8));
            t3.setTag("beach");
            t3.setLikes(20);
            t3.setUser(u3);
            t3.setTotalDistance(120.0);
            t3.setLandmarks(Arrays.asList(l4, l10));

            Trip t4 = new Trip();
            t4.setTitle("Lake & Forest Weekend");
            t4.setDescription("Batak and Shiroka Polyana reservoir weekend trip.");
            t4.setLongDesc("Fishing, boating and forest hikes.");
            t4.setStops(Arrays.asList(c4, c9));
            t4.setTag("nature");
            t4.setLikes(6);
            t4.setUser(u4);
            t4.setTotalDistance(75.0);
            t4.setLandmarks(Arrays.asList(l7, l9));

            Trip t5 = new Trip();
            t5.setTitle("Southwest Gems");
            t5.setDescription("Visit Melnik and Alino Lake area for food and scenery.");
            t5.setLongDesc("Wine, rock formations and quiet lakeside camping.");
            t5.setStops(Arrays.asList(c6, c5));
            t5.setTag("scenic");
            t5.setLikes(3);
            t5.setUser(u5);
            t5.setTotalDistance(210.0);
            t5.setLandmarks(Arrays.asList(l5, l8));

            tripRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));

            // Optionally set favorite trips for users (many-to-many)
            u1.setFavoriteTrips(Collections.singletonList(t1));
            u3.setFavoriteTrips(Arrays.asList(t3, t2));
            userRepository.saveAll(Arrays.asList(u1, u3));
        };
    }
}
