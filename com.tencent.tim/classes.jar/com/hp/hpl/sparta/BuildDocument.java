package com.hp.hpl.sparta;

class BuildDocument
  implements DocumentSource, ParseHandler
{
  private Element currentElement_ = null;
  private final Document doc_ = new Document();
  private final ParseLog log_;
  private ParseSource parseSource_ = null;
  
  public BuildDocument()
  {
    this(null);
  }
  
  public BuildDocument(ParseLog paramParseLog)
  {
    ParseLog localParseLog = paramParseLog;
    if (paramParseLog == null) {
      localParseLog = ParseSource.DEFAULT_LOG;
    }
    this.log_ = localParseLog;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    Element localElement = this.currentElement_;
    if ((localElement.getLastChild() instanceof Text))
    {
      ((Text)localElement.getLastChild()).appendData(paramArrayOfChar, paramInt1, paramInt2);
      return;
    }
    localElement.appendChildNoChecking(new Text(new String(paramArrayOfChar, paramInt1, paramInt2)));
  }
  
  public void endDocument() {}
  
  public void endElement(Element paramElement)
  {
    this.currentElement_ = this.currentElement_.getParentNode();
  }
  
  public Document getDocument()
  {
    return this.doc_;
  }
  
  public int getLineNumber()
  {
    if (this.parseSource_ != null) {
      return this.parseSource_.getLineNumber();
    }
    return -1;
  }
  
  public ParseSource getParseSource()
  {
    return this.parseSource_;
  }
  
  public String getSystemId()
  {
    if (this.parseSource_ != null) {
      return this.parseSource_.getSystemId();
    }
    return null;
  }
  
  public void setParseSource(ParseSource paramParseSource)
  {
    this.parseSource_ = paramParseSource;
    this.doc_.setSystemId(paramParseSource.toString());
  }
  
  public void startDocument() {}
  
  public void startElement(Element paramElement)
  {
    if (this.currentElement_ == null) {
      this.doc_.setDocumentElement(paramElement);
    }
    for (;;)
    {
      this.currentElement_ = paramElement;
      return;
      this.currentElement_.appendChild(paramElement);
    }
  }
  
  public String toString()
  {
    if (this.parseSource_ != null) {
      return "BuildDoc: " + this.parseSource_.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.BuildDocument
 * JD-Core Version:    0.7.0.1
 */