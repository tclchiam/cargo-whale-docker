package com.cargowhale.docker.service;

import com.cargowhale.docker.client.ContainerClient;
import com.cargowhale.docker.domain.ChangeStatusRequest;
import com.cargowhale.docker.domain.ChangeStatusResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContainerServiceTest {

    @InjectMocks
    private ContainerService service;

    @Mock
    private ContainerClient client;

    @Test
    public void getAllContainersReturnsAllContainersFromClient() {
        String expected = "ALL THE CATALOGS";
        when(this.client.getAllContainers()).thenReturn(expected);

        String actual = this.service.getAllContainers();

        assertThat(actual, is(expected));
    }

    @Test
    public void getFilteredContainersReturnsAllRunningContainers() {
        String expected = "ALL RUNNING CATALOGS";
        String filter = "running";

        when(this.client.getFilteredContainers(filter)).thenReturn(expected);

        String actual = this.service.getFilteredContainers(filter);

        assertThat(actual, is(expected));
    }

    @Test
    public void setContainerStateReturnsContainerNameFromClient() {
        String name = "stoppedContainer";
        String status = "start";
        String expectedName = "runningContainer";

        ChangeStatusRequest request = new ChangeStatusRequest(status);

        when(this.client.setContainerStatus(name, status)).thenReturn(expectedName);

        ChangeStatusResponse actual = this.service.setContainerStatus(name, request);
        assertThat(actual.getName(), is(expectedName));
    }
}