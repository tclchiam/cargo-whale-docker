package com.cargowhale.docker.container.info;

import com.cargowhale.docker.client.ContainerInfoClient;
import com.cargowhale.docker.client.DockerContainerFilters;
import com.cargowhale.docker.container.*;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContainerInfoServiceTest {

    @InjectMocks
    private ContainerInfoService service;

    @Mock
    private ContainerInfoClient client;

    @Test
    public void getAllContainersReturnsAllContainersFromClient() {
        List<ContainerInfoVM> expectedContainerList = Collections.singletonList(mock(ContainerInfoVM.class));

        when(this.client.getAllContainers()).thenReturn(expectedContainerList);

        ContainerInfoCollectionVM actual = this.service.getAllContainers();

        assertThat(actual.getContainers(), is(expectedContainerList));
    }

    @Test
    public void getFilteredContainersReturnsFilteredContainers() {
        ContainerState[] containerStatuses = Arrays.array(ContainerState.DEAD, ContainerState.PAUSED);

        StateFilters stateFilters = new StateFilters(containerStatuses);
        DockerContainerFilters filters = new DockerContainerFilters(containerStatuses);
        List<ContainerInfoVM> expectedContainerList = Collections.singletonList(mock(ContainerInfoVM.class));

        when(this.client.getFilteredContainers(filters)).thenReturn(expectedContainerList);

        ContainerInfoCollectionVM actual = this.service.getContainersFilterByStatus(stateFilters);

        assertThat(actual.getContainers(), is(expectedContainerList));
    }

    @Test
    public void getContainerDetailsById() throws Exception {
        String containerId = "container id string";
        ContainerDetails containerDetails = mock(ContainerDetails.class);

        when(this.client.getContainerDetailsById(containerId)).thenReturn(containerDetails);

        assertThat(this.service.getContainerDetailsById(containerId), is(containerDetails));
    }
}