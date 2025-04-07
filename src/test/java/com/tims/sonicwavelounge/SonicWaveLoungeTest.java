package com.tims.sonicwavelounge;

import com.tims.AbstractTest;
import com.tims.sonicwavelounge.model.SonicWaveLoungeTestData;
import com.tims.util.Config;
import com.tims.util.Constants;
import com.tims.util.JsonUtil;
import com.timsguru.sonicwavelounge.SWLMainPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SonicWaveLoungeTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(SonicWaveLoungeTest.class);
    private SWLMainPage swlMainPage;
    private SonicWaveLoungeTestData sonicWaveLoungeTestData;

    @BeforeTest
    @Parameters("testDataPath")
    public void setParameters(String testDataPath) {
        this.swlMainPage = new SWLMainPage(driver);
        this.sonicWaveLoungeTestData = JsonUtil.getTestData(testDataPath, SonicWaveLoungeTestData.class);

    }

    @Test
    public void checkTitle() {
        swlMainPage.goTo(Config.get(Constants.SONIC_WAVE_LOUNGE_URL));
        log.info(swlMainPage.getPageTitle());
        Assert.assertEquals(swlMainPage.getPageTitle(), sonicWaveLoungeTestData.homePageTitle() );
    }

}
