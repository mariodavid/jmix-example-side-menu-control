package de.diedavids.jmix.example.sidemenucontrol.security;

import de.diedavids.jmix.example.sidemenucontrol.entity.User;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

@ResourceRole(name = "CustomerReadRole", code = "customer-read-role")
public interface CustomerReadRole {
    @EntityAttributePolicy(entityClass = User.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = User.class, actions = EntityPolicyAction.ALL)
    void user();


    @MenuPolicy(
            menuIds = {"Customer.browse"}
    )
    @ScreenPolicy(
            screenIds = {"Customer.browse"})
    void customer();
}