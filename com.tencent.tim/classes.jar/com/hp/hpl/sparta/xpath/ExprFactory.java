package com.hp.hpl.sparta.xpath;

import java.io.IOException;

public class ExprFactory
{
  static BooleanExpr createExpr(XPath paramXPath, SimpleStreamTokenizer paramSimpleStreamTokenizer)
    throws XPathException, IOException
  {
    int i;
    switch (paramSimpleStreamTokenizer.ttype)
    {
    default: 
      throw new XPathException(paramXPath, "at beginning of expression", paramSimpleStreamTokenizer, "@, number, or text()");
    case -2: 
      i = paramSimpleStreamTokenizer.nval;
      paramSimpleStreamTokenizer.nextToken();
      return new PositionEqualsExpr(i);
    case 64: 
      if (paramSimpleStreamTokenizer.nextToken() != -3) {
        throw new XPathException(paramXPath, "after @", paramSimpleStreamTokenizer, "name");
      }
      String str = paramSimpleStreamTokenizer.sval;
      switch (paramSimpleStreamTokenizer.nextToken())
      {
      default: 
        return new AttrExistsExpr(str);
      case 61: 
        paramSimpleStreamTokenizer.nextToken();
        if ((paramSimpleStreamTokenizer.ttype != 34) && (paramSimpleStreamTokenizer.ttype != 39)) {
          throw new XPathException(paramXPath, "right hand side of equals", paramSimpleStreamTokenizer, "quoted string");
        }
        paramXPath = paramSimpleStreamTokenizer.sval;
        paramSimpleStreamTokenizer.nextToken();
        return new AttrEqualsExpr(str, paramXPath);
      case 60: 
        paramSimpleStreamTokenizer.nextToken();
        if ((paramSimpleStreamTokenizer.ttype == 34) || (paramSimpleStreamTokenizer.ttype == 39)) {}
        for (i = Integer.parseInt(paramSimpleStreamTokenizer.sval);; i = paramSimpleStreamTokenizer.nval)
        {
          paramSimpleStreamTokenizer.nextToken();
          return new AttrLessExpr(str, i);
          if (paramSimpleStreamTokenizer.ttype != -2) {
            break;
          }
        }
        throw new XPathException(paramXPath, "right hand side of less-than", paramSimpleStreamTokenizer, "quoted string or number");
      case 62: 
        paramSimpleStreamTokenizer.nextToken();
        if ((paramSimpleStreamTokenizer.ttype == 34) || (paramSimpleStreamTokenizer.ttype == 39)) {}
        for (i = Integer.parseInt(paramSimpleStreamTokenizer.sval);; i = paramSimpleStreamTokenizer.nval)
        {
          paramSimpleStreamTokenizer.nextToken();
          return new AttrGreaterExpr(str, i);
          if (paramSimpleStreamTokenizer.ttype != -2) {
            break;
          }
        }
        throw new XPathException(paramXPath, "right hand side of greater-than", paramSimpleStreamTokenizer, "quoted string or number");
      }
      paramSimpleStreamTokenizer.nextToken();
      if (paramSimpleStreamTokenizer.ttype != 61) {
        throw new XPathException(paramXPath, "after !", paramSimpleStreamTokenizer, "=");
      }
      paramSimpleStreamTokenizer.nextToken();
      if ((paramSimpleStreamTokenizer.ttype != 34) && (paramSimpleStreamTokenizer.ttype != 39)) {
        throw new XPathException(paramXPath, "right hand side of !=", paramSimpleStreamTokenizer, "quoted string");
      }
      paramXPath = paramSimpleStreamTokenizer.sval;
      paramSimpleStreamTokenizer.nextToken();
      return new AttrNotEqualsExpr(str, paramXPath);
    }
    if (!paramSimpleStreamTokenizer.sval.equals("text")) {
      throw new XPathException(paramXPath, "at beginning of expression", paramSimpleStreamTokenizer, "text()");
    }
    if (paramSimpleStreamTokenizer.nextToken() != 40) {
      throw new XPathException(paramXPath, "after text", paramSimpleStreamTokenizer, "(");
    }
    if (paramSimpleStreamTokenizer.nextToken() != 41) {
      throw new XPathException(paramXPath, "after text(", paramSimpleStreamTokenizer, ")");
    }
    switch (paramSimpleStreamTokenizer.nextToken())
    {
    default: 
      return TextExistsExpr.INSTANCE;
    case 61: 
      paramSimpleStreamTokenizer.nextToken();
      if ((paramSimpleStreamTokenizer.ttype != 34) && (paramSimpleStreamTokenizer.ttype != 39)) {
        throw new XPathException(paramXPath, "right hand side of equals", paramSimpleStreamTokenizer, "quoted string");
      }
      paramXPath = paramSimpleStreamTokenizer.sval;
      paramSimpleStreamTokenizer.nextToken();
      return new TextEqualsExpr(paramXPath);
    }
    paramSimpleStreamTokenizer.nextToken();
    if (paramSimpleStreamTokenizer.ttype != 61) {
      throw new XPathException(paramXPath, "after !", paramSimpleStreamTokenizer, "=");
    }
    paramSimpleStreamTokenizer.nextToken();
    if ((paramSimpleStreamTokenizer.ttype != 34) && (paramSimpleStreamTokenizer.ttype != 39)) {
      throw new XPathException(paramXPath, "right hand side of !=", paramSimpleStreamTokenizer, "quoted string");
    }
    paramXPath = paramSimpleStreamTokenizer.sval;
    paramSimpleStreamTokenizer.nextToken();
    return new TextNotEqualsExpr(paramXPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.ExprFactory
 * JD-Core Version:    0.7.0.1
 */