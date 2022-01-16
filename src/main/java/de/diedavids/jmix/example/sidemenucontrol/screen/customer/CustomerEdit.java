package de.diedavids.jmix.example.sidemenucontrol.screen.customer;

import io.jmix.ui.screen.*;
import de.diedavids.jmix.example.sidemenucontrol.entity.Customer;

@UiController("Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
public class CustomerEdit extends StandardEditor<Customer> {
}