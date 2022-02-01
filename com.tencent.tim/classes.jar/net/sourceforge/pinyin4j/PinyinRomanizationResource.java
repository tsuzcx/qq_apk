package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.Document;
import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.Parser;
import java.io.FileNotFoundException;
import java.io.IOException;

class PinyinRomanizationResource
{
  private Document pinyinMappingDoc;
  
  private PinyinRomanizationResource()
  {
    initializeResource();
  }
  
  PinyinRomanizationResource(1 param1)
  {
    this();
  }
  
  static PinyinRomanizationResource getInstance()
  {
    return PinyinRomanizationSystemResourceHolder.theInstance;
  }
  
  private void initializeResource()
  {
    try
    {
      setPinyinMappingDoc(Parser.parse("", ResourceHelper.getResourceInputStream("/pinyindb/pinyin_mapping.xml")));
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
  }
  
  private void setPinyinMappingDoc(Document paramDocument)
  {
    this.pinyinMappingDoc = paramDocument;
  }
  
  Document getPinyinMappingDoc()
  {
    return this.pinyinMappingDoc;
  }
  
  static class PinyinRomanizationSystemResourceHolder
  {
    static final PinyinRomanizationResource theInstance = new PinyinRomanizationResource(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.sourceforge.pinyin4j.PinyinRomanizationResource
 * JD-Core Version:    0.7.0.1
 */