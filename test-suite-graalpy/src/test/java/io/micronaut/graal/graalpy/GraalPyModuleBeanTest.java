package io.micronaut.graal.graalpy;

import io.micronaut.context.BeanContext;
import jakarta.inject.Inject;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.JRE;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest(startApplication = false)
public class GraalPyModuleBeanTest {

    @Inject
    SysModule sysModule;

    @Inject
    BeanContext beanContext;

    @Test
    @DisabledOnJre(JRE.JAVA_17)
    void testGraalPyModuleBean() {
        assertTrue(beanContext.containsBean(SysModule.class));

        assertFalse(sysModule.is_finalizing());
        assertTrue(Arrays.asList(sysModule.path()).contains("/graalpy_vfs/src"));
    }

}
