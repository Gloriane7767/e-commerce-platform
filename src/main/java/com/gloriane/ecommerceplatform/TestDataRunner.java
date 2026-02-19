package com.gloriane.ecommerceplatform;

import com.gloriane.ecommerceplatform.entity.Address;
import com.gloriane.ecommerceplatform.entity.Customer;
import com.gloriane.ecommerceplatform.entity.UserProfile;
import com.gloriane.ecommerceplatform.repository.AddressRepository;
import com.gloriane.ecommerceplatform.repository.CustomerRepository;
import com.gloriane.ecommerceplatform.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataRunner implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final UserProfileRepository userProfileRepository;

    @Override
    public void run(String... args) {
        // Create Address
        Address address = Address.builder()
                .street("123 Main St")
                .city("Stockholm")
                .zipCode("12345")
                .build();

        // Create UserProfile
        UserProfile profile = UserProfile.builder()
                .nickName("johndoe")
                .phoneNumber("555-1234")
                .bio("Test user bio")
                .build();

        // Create Customer
        Customer customer = Customer.builder()
                .firstname("John")
                .lastname("Doe")
                .email("john.doe@example.com")
                .address(address)
                .userProfile(profile)
                .build();

        // Save
        customerRepository.save(customer);

        System.out.println("✅ Customer saved successfully!");

        // Test queries
        customerRepository.findByEmail("john.doe@example.com")
                .ifPresent(c -> System.out.println("✅ Found customer: " + c.getFirstname() + " " + c.getLastname()));

        System.out.println("✅ Customers in Stockholm: " + customerRepository.findByAddressCity("Stockholm").size());
        System.out.println("✅ Total customers: " + customerRepository.count());
    }
}
