package com.jovenes.propuestas.controllers;


import com.github.javafaker.Faker;
import com.jovenes.propuestas.entities.*;
import com.jovenes.propuestas.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    FAQRepository faqRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    RewardRepository rewardRepository;

    @Autowired
    PurchaseRepository purchaseRepository;
    @Autowired
    UpdateRepository updateRepository;
    @Autowired
    UserRepository userRepository;
    @PostMapping("/api/setFakeData")
    public void hello() {
        try{
            Faker faker = new Faker();
            List<FAQ> faqs = new ArrayList<>();
            List<Address> addresses = new ArrayList<>();
            List<Question> questions = new ArrayList<>();

            List<Update> updates = new ArrayList<>();

            User user = User.builder()
                    .email("santiscally@gmail.com")
                    .biography(faker.paragraph())
                    .firstName(faker.firstName())
                    .username(faker.firstName())
                    .lastName(faker.lastName())
                    .password("password")
                    .createdByUser(Integer.valueOf(faker.numerify("5")))
                    .createdTime(LocalDateTime.now())
                    .build();
            user = this.userRepository.save(user);

            Owner owner = Owner.builder()
                    .email("guidojtorres@gmail.com")
                    .biography(faker.paragraph())
                    .firstName(faker.firstName())
                    .username(faker.firstName())
                    .lastName(faker.lastName())
                    .password("password")
                    .createdByUser(Integer.valueOf(faker.numerify("5")))
                    .createdTime(LocalDateTime.now())
                    .build();

            owner = this.userRepository.save(owner);

            Project project = Project.builder()
                    .title("La nueva vida")
                    .subtitle(faker.sentence())
                    .description(faker.paragraph())
                    .limitDate(LocalDateTime.now())
                    .category("Arte")
                    .collectedFunds(50000)
                    .goal(60000000)
                    .owner(owner)
                    .createdByUser(owner.getId())
                    .createdTime(LocalDateTime.now())
                    .build();

            project = this.projectRepository.save(project);
            // Generate 5 FAQ entities
            for (int i = 0; i < 5; i++) {
                FAQ faq = FAQ.builder()
                        .question(faker.sentence())
                        .answer(faker.paragraph())
                        .project(project)
                        .createdByUser(owner.getId())
                        .createdTime(LocalDateTime.now())
                        .build();

                faqs.add(faq);

            }
            this.faqRepository.saveAll(faqs);

            for (int i = 0; i < 5; i++) {
                Address address = Address.builder()
                        .street(faker.streetAddress(false))
                        .floor(faker.numerify("1"))
                        .city(faker.cityPrefix())
                        .apartment(faker.numerify("2"))
                        .province(faker.stateAbbr())
                        .postalCode(faker.zipCode())
                        .country(faker.country())
                        .phone(faker.phoneNumber())
                        .nickname(faker.firstName())
                        .user(user)
                        .createdByUser(user.getId())
                        .createdTime(LocalDateTime.now())
                        .build();

                addresses.add(address);
            }
            this.addressRepository.saveAll(addresses);

            for (int i = 0; i < 5; i++) {
                Question question = Question.builder()
                        .question(faker.sentence())
                        .answer(faker.paragraph())
                        .user(user)
                        .project(project)
                        .createdByUser(user.getId())
                        .createdTime(LocalDateTime.now())
                        .build();
                questions.add(question);
            }
            this.questionRepository.saveAll(questions);

            for (int i = 0; i < 5; i++) {
                Reward reward = Reward.builder()
                        .title(faker.sentence())
                        .description(faker.paragraph())
                        .price(Double.parseDouble(faker.numerify("1")))
                        .project(project)
                        .createdByUser(owner.getId())
                        .createdTime(LocalDateTime.now())
                        .build();
                reward = this.rewardRepository.save(reward);
                Purchase purchase = Purchase.builder()
                        .user(user)
                        .reward(reward)
                        .quantity(2)
                        .deliveryDate(LocalDateTime.now())
                        .createdByUser(user.getId())
                        .createdTime(LocalDateTime.now())
                        .build();

                this.purchaseRepository.save(purchase);
            }


            for (int i = 0; i < 5; i++) {
                Update update = Update.builder()
                        .title(faker.sentence())
                        .description(faker.paragraph())
                        .project(project)
                        .createdByUser(owner.getId())
                        .createdTime(LocalDateTime.now())
                        .build();

                updates.add(update);
            }
            this.updateRepository.saveAll(updates);







        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
