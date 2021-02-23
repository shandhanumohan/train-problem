package com.edstem.code.pairing.trainproblem;

import com.edstem.code.pairing.trainproblem.entity.TrainEntity;
import com.edstem.code.pairing.trainproblem.service.TrainService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TrainProblemApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@MockBean
	private TrainService service;

	@Before
	public void init() {
		this.mockMvc = MockMvcBuilders
				.webAppContextSetup(webApplicationContext)
				.build();
	}
	@Test
	public void testGetAllTrains() throws Exception {
		Mockito.when(service.getTrainInfo()).thenReturn(this.sampleTrains());
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/trains"))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}

	@Test
	public void testTrainById() throws Exception {
		Mockito.when(service.getTrain(Mockito.anyLong())).thenReturn(this.sampleTrain());
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/train/2"))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}

	@Test
	public void testTrainByIdNotFound() throws Exception {
		Mockito.when(service.getTrainInfo()).thenReturn(null);
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/train/2"))
				.andExpect(MockMvcResultMatchers.status().is4xxClientError());
	}

	private List<TrainEntity> sampleTrains() {
		List<TrainEntity> trainEntities = new ArrayList<>();
		TrainEntity entity = new TrainEntity();
		entity.setName("Test");
		entity.setId(2l);
		trainEntities.add(entity);
		return trainEntities;
	}


	private Optional<TrainEntity> sampleTrain() {

		TrainEntity entity = new TrainEntity();
		entity.setName("Test");
		entity.setId(2l);
		return Optional.of(entity);
	}
}
