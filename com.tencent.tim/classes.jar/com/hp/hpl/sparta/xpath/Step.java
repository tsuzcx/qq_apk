package com.hp.hpl.sparta.xpath;

import java.io.IOException;

public class Step
{
  public static Step DOT = new Step(ThisNodeTest.INSTANCE, TrueExpr.INSTANCE);
  private final boolean multiLevel_;
  private final NodeTest nodeTest_;
  private final BooleanExpr predicate_;
  
  Step(NodeTest paramNodeTest, BooleanExpr paramBooleanExpr)
  {
    this.nodeTest_ = paramNodeTest;
    this.predicate_ = paramBooleanExpr;
    this.multiLevel_ = false;
  }
  
  Step(XPath paramXPath, boolean paramBoolean, SimpleStreamTokenizer paramSimpleStreamTokenizer)
    throws XPathException, IOException
  {
    this.multiLevel_ = paramBoolean;
    switch (paramSimpleStreamTokenizer.ttype)
    {
    default: 
      throw new XPathException(paramXPath, "at begininning of step", paramSimpleStreamTokenizer, "'.' or '*' or name");
    case 46: 
      if (paramSimpleStreamTokenizer.nextToken() == 46) {
        this.nodeTest_ = ParentNodeTest.INSTANCE;
      }
      break;
    }
    while (paramSimpleStreamTokenizer.nextToken() == 91)
    {
      paramSimpleStreamTokenizer.nextToken();
      this.predicate_ = ExprFactory.createExpr(paramXPath, paramSimpleStreamTokenizer);
      if (paramSimpleStreamTokenizer.ttype != 93)
      {
        throw new XPathException(paramXPath, "after predicate expression", paramSimpleStreamTokenizer, "]");
        paramSimpleStreamTokenizer.pushBack();
        this.nodeTest_ = ThisNodeTest.INSTANCE;
        continue;
        this.nodeTest_ = AllElementTest.INSTANCE;
        continue;
        if (paramSimpleStreamTokenizer.nextToken() != -3) {
          throw new XPathException(paramXPath, "after @ in node test", paramSimpleStreamTokenizer, "name");
        }
        this.nodeTest_ = new AttrTest(paramSimpleStreamTokenizer.sval);
        continue;
        if (paramSimpleStreamTokenizer.sval.equals("text"))
        {
          if ((paramSimpleStreamTokenizer.nextToken() != 40) || (paramSimpleStreamTokenizer.nextToken() != 41)) {
            throw new XPathException(paramXPath, "after text", paramSimpleStreamTokenizer, "()");
          }
          this.nodeTest_ = TextTest.INSTANCE;
        }
        else
        {
          this.nodeTest_ = new ElementTest(paramSimpleStreamTokenizer.sval);
        }
      }
      else
      {
        paramSimpleStreamTokenizer.nextToken();
        return;
      }
    }
    this.predicate_ = TrueExpr.INSTANCE;
  }
  
  public NodeTest getNodeTest()
  {
    return this.nodeTest_;
  }
  
  public BooleanExpr getPredicate()
  {
    return this.predicate_;
  }
  
  public boolean isMultiLevel()
  {
    return this.multiLevel_;
  }
  
  public boolean isStringValue()
  {
    return this.nodeTest_.isStringValue();
  }
  
  public String toString()
  {
    return this.nodeTest_.toString() + this.predicate_.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.Step
 * JD-Core Version:    0.7.0.1
 */