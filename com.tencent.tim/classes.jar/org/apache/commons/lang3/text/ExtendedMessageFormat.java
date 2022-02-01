package org.apache.commons.lang3.text;

import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

public class ExtendedMessageFormat
  extends MessageFormat
{
  private static final String DUMMY_PATTERN = "";
  private static final char END_FE = '}';
  private static final int HASH_SEED = 31;
  private static final char QUOTE = '\'';
  private static final char START_FE = '{';
  private static final char START_FMT = ',';
  private static final long serialVersionUID = -2362048321261811743L;
  private final Map<String, ? extends FormatFactory> registry;
  private String toPattern;
  
  static
  {
    if (!ExtendedMessageFormat.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ExtendedMessageFormat(String paramString)
  {
    this(paramString, Locale.getDefault());
  }
  
  public ExtendedMessageFormat(String paramString, Locale paramLocale)
  {
    this(paramString, paramLocale, null);
  }
  
  public ExtendedMessageFormat(String paramString, Locale paramLocale, Map<String, ? extends FormatFactory> paramMap)
  {
    super("");
    setLocale(paramLocale);
    this.registry = paramMap;
    applyPattern(paramString);
  }
  
  public ExtendedMessageFormat(String paramString, Map<String, ? extends FormatFactory> paramMap)
  {
    this(paramString, Locale.getDefault(), paramMap);
  }
  
  private StringBuilder appendQuotedString(String paramString, ParsePosition paramParsePosition, StringBuilder paramStringBuilder)
  {
    assert (paramString.toCharArray()[paramParsePosition.getIndex()] == '\'') : "Quoted string must start with quote character";
    if (paramStringBuilder != null) {
      paramStringBuilder.append('\'');
    }
    next(paramParsePosition);
    int j = paramParsePosition.getIndex();
    char[] arrayOfChar = paramString.toCharArray();
    int i = paramParsePosition.getIndex();
    while (i < paramString.length()) {
      switch (arrayOfChar[paramParsePosition.getIndex()])
      {
      default: 
        next(paramParsePosition);
        i += 1;
        break;
      case '\'': 
        next(paramParsePosition);
        if (paramStringBuilder == null) {
          return null;
        }
        return paramStringBuilder.append(arrayOfChar, j, paramParsePosition.getIndex() - j);
      }
    }
    throw new IllegalArgumentException("Unterminated quoted string at position " + j);
  }
  
  private boolean containsElements(Collection<?> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty())) {}
    do
    {
      while (!paramCollection.hasNext())
      {
        return false;
        paramCollection = paramCollection.iterator();
      }
    } while (paramCollection.next() == null);
    return true;
  }
  
  private Format getFormat(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (this.registry != null)
    {
      int i = paramString.indexOf(',');
      if (i <= 0) {
        break label94;
      }
      localObject1 = paramString.substring(0, i).trim();
      localObject2 = paramString.substring(i + 1).trim();
      paramString = (String)localObject1;
    }
    label94:
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      FormatFactory localFormatFactory = (FormatFactory)this.registry.get(paramString);
      localObject2 = localObject3;
      if (localFormatFactory != null) {
        localObject2 = localFormatFactory.getFormat(paramString, (String)localObject1, getLocale());
      }
      return localObject2;
    }
  }
  
  private void getQuotedString(String paramString, ParsePosition paramParsePosition)
  {
    appendQuotedString(paramString, paramParsePosition, null);
  }
  
  private String insertFormats(String paramString, ArrayList<String> paramArrayList)
  {
    int i = 0;
    if (!containsElements(paramArrayList)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() * 2);
    ParsePosition localParsePosition = new ParsePosition(0);
    int j = -1;
    label217:
    for (;;)
    {
      if (localParsePosition.getIndex() < paramString.length())
      {
        char c = paramString.charAt(localParsePosition.getIndex());
        switch (c)
        {
        }
        for (;;)
        {
          localStringBuilder.append(c);
          next(localParsePosition);
          break;
          appendQuotedString(paramString, localParsePosition, localStringBuilder);
          break;
          i += 1;
          localStringBuilder.append('{').append(readArgumentIndex(paramString, next(localParsePosition)));
          if (i != 1) {
            break label217;
          }
          j += 1;
          String str = (String)paramArrayList.get(j);
          if (str != null) {
            localStringBuilder.append(',').append(str);
          }
          break;
          i -= 1;
        }
      }
      return localStringBuilder.toString();
    }
  }
  
  private ParsePosition next(ParsePosition paramParsePosition)
  {
    paramParsePosition.setIndex(paramParsePosition.getIndex() + 1);
    return paramParsePosition;
  }
  
  private String parseFormatDescription(String paramString, ParsePosition paramParsePosition)
  {
    int k = paramParsePosition.getIndex();
    seekNonWs(paramString, paramParsePosition);
    int m = paramParsePosition.getIndex();
    int i = 1;
    if (paramParsePosition.getIndex() < paramString.length())
    {
      switch (paramString.charAt(paramParsePosition.getIndex()))
      {
      }
      for (;;)
      {
        next(paramParsePosition);
        break;
        i += 1;
        continue;
        int j = i - 1;
        i = j;
        if (j == 0)
        {
          return paramString.substring(m, paramParsePosition.getIndex());
          getQuotedString(paramString, paramParsePosition);
        }
      }
    }
    throw new IllegalArgumentException("Unterminated format element at position " + k);
  }
  
  private int readArgumentIndex(String paramString, ParsePosition paramParsePosition)
  {
    int j = paramParsePosition.getIndex();
    seekNonWs(paramString, paramParsePosition);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while ((i == 0) && (paramParsePosition.getIndex() < paramString.length()))
    {
      char c2 = paramString.charAt(paramParsePosition.getIndex());
      char c1 = c2;
      if (Character.isWhitespace(c2))
      {
        seekNonWs(paramString, paramParsePosition);
        c2 = paramString.charAt(paramParsePosition.getIndex());
        c1 = c2;
        if (c2 != ',')
        {
          c1 = c2;
          if (c2 != '}')
          {
            i = 1;
            next(paramParsePosition);
            continue;
          }
        }
      }
      if (((c1 == ',') || (c1 == '}')) && (localStringBuilder.length() > 0)) {
        try
        {
          i = Integer.parseInt(localStringBuilder.toString());
          return i;
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
      if (!Character.isDigit(c1)) {}
      for (i = 1;; i = 0)
      {
        localStringBuilder.append(c1);
        break;
      }
    }
    if (i != 0) {
      throw new IllegalArgumentException("Invalid format argument index at position " + j + ": " + paramString.substring(j, paramParsePosition.getIndex()));
    }
    throw new IllegalArgumentException("Unterminated format element at position " + j);
  }
  
  private void seekNonWs(String paramString, ParsePosition paramParsePosition)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int i;
    do
    {
      i = StrMatcher.splitMatcher().isMatch(arrayOfChar, paramParsePosition.getIndex());
      paramParsePosition.setIndex(paramParsePosition.getIndex() + i);
    } while ((i > 0) && (paramParsePosition.getIndex() < paramString.length()));
  }
  
  public final void applyPattern(String paramString)
  {
    int j = 0;
    if (this.registry == null)
    {
      super.applyPattern(paramString);
      this.toPattern = super.toPattern();
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    ParsePosition localParsePosition = new ParsePosition(0);
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    label120:
    int k;
    Object localObject;
    Format localFormat1;
    for (;;)
    {
      if (localParsePosition.getIndex() < paramString.length()) {
        switch (arrayOfChar[localParsePosition.getIndex()])
        {
        default: 
          localStringBuilder.append(arrayOfChar[localParsePosition.getIndex()]);
          next(localParsePosition);
          break;
        case '\'': 
          appendQuotedString(paramString, localParsePosition, localStringBuilder);
          break;
        case '{': 
          i += 1;
          seekNonWs(paramString, localParsePosition);
          k = localParsePosition.getIndex();
          int m = readArgumentIndex(paramString, next(localParsePosition));
          localStringBuilder.append('{').append(m);
          seekNonWs(paramString, localParsePosition);
          if (arrayOfChar[localParsePosition.getIndex()] != ',') {
            break label482;
          }
          String str = parseFormatDescription(paramString, next(localParsePosition));
          Format localFormat2 = getFormat(str);
          localObject = str;
          localFormat1 = localFormat2;
          if (localFormat2 == null)
          {
            localStringBuilder.append(',').append(str);
            localFormat1 = localFormat2;
            localObject = str;
          }
          break;
        }
      }
    }
    for (;;)
    {
      localArrayList1.add(localFormat1);
      if (localFormat1 == null) {
        localObject = null;
      }
      localArrayList2.add(localObject);
      if (localArrayList1.size() == i)
      {
        bool = true;
        Validate.isTrue(bool);
        if (localArrayList2.size() != i) {
          break label382;
        }
      }
      label382:
      for (boolean bool = true;; bool = false)
      {
        Validate.isTrue(bool);
        if (arrayOfChar[localParsePosition.getIndex()] == '}') {
          break label479;
        }
        throw new IllegalArgumentException("Unreadable format element at position " + k);
        bool = false;
        break;
      }
      super.applyPattern(localStringBuilder.toString());
      this.toPattern = insertFormats(super.toPattern(), localArrayList2);
      if (!containsElements(localArrayList1)) {
        break;
      }
      paramString = getFormats();
      localObject = localArrayList1.iterator();
      i = j;
      while (((Iterator)localObject).hasNext())
      {
        localFormat1 = (Format)((Iterator)localObject).next();
        if (localFormat1 != null) {
          paramString[i] = localFormat1;
        }
        i += 1;
      }
      super.setFormats(paramString);
      return;
      label479:
      break label120;
      label482:
      localObject = null;
      localFormat1 = null;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      if (ObjectUtils.notEqual(getClass(), paramObject.getClass())) {
        return false;
      }
      paramObject = (ExtendedMessageFormat)paramObject;
      if (ObjectUtils.notEqual(this.toPattern, paramObject.toPattern)) {
        return false;
      }
    } while (!ObjectUtils.notEqual(this.registry, paramObject.registry));
    return false;
  }
  
  public int hashCode()
  {
    return (super.hashCode() * 31 + ObjectUtils.hashCode(this.registry)) * 31 + ObjectUtils.hashCode(this.toPattern);
  }
  
  public void setFormat(int paramInt, Format paramFormat)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setFormatByArgumentIndex(int paramInt, Format paramFormat)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setFormats(Format[] paramArrayOfFormat)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setFormatsByArgumentIndex(Format[] paramArrayOfFormat)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toPattern()
  {
    return this.toPattern;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.text.ExtendedMessageFormat
 * JD-Core Version:    0.7.0.1
 */