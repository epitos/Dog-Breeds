package com.example.dogbreeds

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.dogbreeds.data.api.ApiService
import com.example.dogbreeds.data.model.Response
import com.example.dogbreeds.data.repository.Repository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class RepositoryTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var apiService: ApiService

    private lateinit var repository: Repository

    @Before
    fun setUp() {
        repository = Repository(apiService)
    }

    @Test
    fun getMainBreedsResponse() {
        testCoroutineRule.runBlockingTest {

            doReturn(Response()).`when`(apiService).getMainBreeds()

            repository.getMainBreeds()

            verify(apiService).getMainBreeds()
        }
    }

    @Test
    fun getSubBreedsResponse() {
        testCoroutineRule.runBlockingTest {

            doReturn(Response()).`when`(apiService).getSubBreeds()

            repository.getSubBreeds()

            verify(apiService).getSubBreeds()
        }
    }

    @Test
    fun getMainBreedImagesResponse() {
        val mainBreed = "bulldog"

        testCoroutineRule.runBlockingTest {

            doReturn(Response()).`when`(apiService).getMainBreedImages(mainBreed)

            repository.getMainBreedImages(mainBreed)

            verify(apiService).getMainBreedImages(mainBreed)
        }
    }

    @Test
    fun getSubBreedImagesResponse() {
        val mainBreed = "greyhound"
        val subBreed = "english"

        testCoroutineRule.runBlockingTest {

            doReturn(Response()).`when`(apiService).getSubBreedImages(mainBreed, subBreed)

            repository.getSubBreedImages(mainBreed, subBreed)

            verify(apiService).getSubBreedImages(mainBreed, subBreed)
        }
    }
}
