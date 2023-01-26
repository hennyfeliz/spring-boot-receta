package com.example.demo.controller.impl;

import com.example.demo.Controller.impl.CantidadControllerImpl;
import com.example.demo.Entity.Cantidad;
import com.example.demo.Service.CantidadService;
import com.example.demo.controller.impl.CustomUtils;
import com.example.demo.dto.CantidadDTO;
import com.example.demo.mapper.CantidadMapper;
import com.example.demo.mapper.ReferenceMapper;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class CantidadControllerImplTest {
  //TODO: create the data Test generator class CantidadBuilder
  private static final String ENDPOINT_URL = "/cantidads";
  @MockBean
  private ReferenceMapper referenceMapper;
  @InjectMocks
  private CantidadControllerImpl cantidadController;
  @MockBean
  private CantidadService cantidadService;
  @MockBean
  private CantidadMapper cantidadMapper;
  @Autowired
  private MockMvc mockMvc;

  @Before
  public void setup() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(this.cantidadController).build();
  }

  @Test
  public void getAll() throws Exception {
    Mockito.when(cantidadMapper.asDTOList(ArgumentMatchers.any())).thenReturn(CantidadBuilder.getListDTO());

    Mockito.when(cantidadService.findAll()).thenReturn(CantidadBuilder.getListEntities());
    mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content()
                    .contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

  }

  @Test
  public void getById() throws Exception {
    Mockito.when(cantidadMapper.asDTO(ArgumentMatchers.any())).thenReturn(CantidadBuilder.getDTO());

    Mockito.when(cantidadService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(CantidadBuilder.getEntity()));

    mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content()
                    .contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
    Mockito.verify(cantidadService, Mockito.times(1)).findById(1L);
    Mockito.verifyNoMoreInteractions(cantidadService);
  }

  @Test
  public void save() throws Exception {
    Mockito.when(cantidadMapper.asEntity(ArgumentMatchers.any())).thenReturn(CantidadBuilder.getEntity());
    Mockito.when(cantidadService.save(ArgumentMatchers.any(Cantidad.class))).thenReturn(CantidadBuilder.getEntity());

    mockMvc.perform(
                    MockMvcRequestBuilders.post(ENDPOINT_URL)
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(CustomUtils.asJsonString(CantidadBuilder.getDTO())))
            .andExpect(MockMvcResultMatchers.status().isCreated());
    Mockito.verify(cantidadService, Mockito.times(1)).save(ArgumentMatchers.any(Cantidad.class));
    Mockito.verifyNoMoreInteractions(cantidadService);
  }

  @Test
  public void update() throws Exception {
    Mockito.when(cantidadMapper.asEntity(ArgumentMatchers.any())).thenReturn(CantidadBuilder.getEntity());
    Mockito.when(cantidadService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(CantidadBuilder.getEntity());

    mockMvc.perform(
                    MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(CustomUtils.asJsonString(CantidadBuilder.getDTO())))
            .andExpect(MockMvcResultMatchers.status().isOk());
    Mockito.verify(cantidadService, Mockito.times(1)).update(ArgumentMatchers.any(Cantidad.class), ArgumentMatchers.anyLong());
    Mockito.verifyNoMoreInteractions(cantidadService);
  }

  @Test
  public void delete() throws Exception {
    Mockito.doNothing().when(cantidadService).deleteById(ArgumentMatchers.anyLong());
    mockMvc.perform(
                    MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    Mockito.verify(cantidadService, Mockito.times(1)).deleteById(Mockito.anyLong());
    Mockito.verifyNoMoreInteractions(cantidadService);
  }