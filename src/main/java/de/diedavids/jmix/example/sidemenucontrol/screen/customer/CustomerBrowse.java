package de.diedavids.jmix.example.sidemenucontrol.screen.customer;

import io.jmix.ui.screen.*;
import de.diedavids.jmix.example.sidemenucontrol.entity.Customer;

@UiController("Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
public class CustomerBrowse extends StandardLookup<Customer> {
}