package br.com.springbootcourse.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.springbootcourse.converter.mocks.MockBook;
import br.com.springbootcourse.data.model.Book;
import br.com.springbootcourse.data.vo.v1.BookVO;
import br.com.springbootcourse.parser.DozerParser;

public class DozerConverterTestBook {


    MockBook inputObject;

    @Before
    public void setUp() {
        inputObject = new MockBook();
    }

    @Test
    public void parseEntityToVOTest() {
        BookVO output = DozerParser.parseObject(inputObject.mockEntity(), BookVO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getKey());
        Assert.assertEquals("Author Test0", output.getAuthor());
        Assert.assertEquals("Lauch Date Test0", output.getLaunchDate());
        Assert.assertEquals("Title Test0", output.getTitle());
        Assert.assertEquals("Price Test0", output.getPrice());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<BookVO> outputList = DozerParser.parseListObjects(inputObject.mockEntityList(), BookVO.class);
        BookVO outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getKey());
        Assert.assertEquals("Author Test0", outputZero.getAuthor());
        Assert.assertEquals("Lauch Date Test0", outputZero.getLaunchDate());
        Assert.assertEquals("Title Test0", outputZero.getTitle());
        Assert.assertEquals("Price Test0", outputZero.getPrice());
        
        BookVO outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getKey());
        Assert.assertEquals("Author Test7", outputSeven.getAuthor());
        Assert.assertEquals("Lauch Date Test7", outputSeven.getLaunchDate());
        Assert.assertEquals("Title Test7", outputSeven.getTitle());
        Assert.assertEquals("Price Test7", outputSeven.getPrice());
        
        BookVO outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        Assert.assertEquals("Author Test12", outputTwelve.getAuthor());
        Assert.assertEquals("Lauch Date Test12", outputTwelve.getLaunchDate());
        Assert.assertEquals("Title Test12", outputTwelve.getTitle());
        Assert.assertEquals("Price Test12", outputTwelve.getPrice());
    }

    @Test
    public void parseVOToEntityTest() {
        Book output = DozerParser.parseObject(inputObject.mockVO(), Book.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("Author Test0", output.getAuthor());
        Assert.assertEquals("Lauch Date Test0", output.getLaunchDate());
        Assert.assertEquals("Title Test0", output.getTitle());
        Assert.assertEquals("Price Test0", output.getPrice());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Book> outputList = DozerParser.parseListObjects(inputObject.mockVOList(), Book.class);
        Book outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("Author Test0", outputZero.getAuthor());
        Assert.assertEquals("Lauch Date Test0", outputZero.getLaunchDate());
        Assert.assertEquals("Title Test0", outputZero.getTitle());
        Assert.assertEquals("Price Test0", outputZero.getPrice());
        
        
        Book outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("Author Test7", outputSeven.getAuthor());
        Assert.assertEquals("Lauch Date Test7", outputSeven.getLaunchDate());
        Assert.assertEquals("Title Test7", outputSeven.getTitle());
        Assert.assertEquals("Price Test7", outputSeven.getPrice());
        
        Book outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("Author Test12", outputTwelve.getAuthor());
		Assert.assertEquals("Lauch Date Test12", outputTwelve.getLaunchDate());
        Assert.assertEquals("Title Test12", outputTwelve.getTitle());
        Assert.assertEquals("Price Test12", outputTwelve.getPrice());
    }
}
