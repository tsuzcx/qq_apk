package com.tencent.ditto.reflect;

import com.tencent.ditto.utils.DittoLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DittoFieldValue
  extends DittoValue
{
  String fieldName;
  private List<AbsValueProcessor> processors;
  
  private List<String> getFieldTokens(String paramString)
  {
    ArrayList localArrayList = new ArrayList(3);
    StringBuilder localStringBuilder = new StringBuilder();
    char[] arrayOfChar = paramString.toCharArray();
    int k = arrayOfChar.length;
    int j = 0;
    int i = 0;
    paramString = localStringBuilder;
    char c;
    if (j < k)
    {
      c = arrayOfChar[j];
      if (c == '\'') {
        if (i == 0)
        {
          i = 1;
          label63:
          paramString.append(c);
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i = 0;
        break label63;
        if ((c != ' ') || (i != 0)) {
          break label123;
        }
        if (paramString.length() == 0) {
          break label192;
        }
        localArrayList.add(paramString.toString());
        paramString = new StringBuilder();
      }
      label123:
      if ((c == '[') || (c == ']') || (c == '.'))
      {
        if (paramString.length() == 0) {
          break label217;
        }
        localArrayList.add(paramString.toString());
        paramString = new StringBuilder();
      }
    }
    label192:
    label217:
    for (;;)
    {
      localArrayList.add(Character.valueOf(c).toString());
      break;
      paramString.append(c);
      break;
      if (paramString.length() != 0) {
        localArrayList.add(paramString.toString());
      }
      return localArrayList;
    }
  }
  
  private void loadProcessors()
  {
    if (this.processors == null)
    {
      Object localObject = getFieldTokens(this.fieldName);
      this.processors = new ArrayList();
      localObject = ((List)localObject).iterator();
      int i = 0;
      if (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if ("[".equals(str)) {
          i = 1;
        }
        for (;;)
        {
          for (;;)
          {
            break;
            if (i == 0) {
              break label131;
            }
            try
            {
              i = Integer.parseInt(str);
              this.processors.add(new ListValueProcessor(Integer.valueOf(i)));
              i = 0;
            }
            catch (Throwable localThrowable)
            {
              this.processors.add(new MapValueProcessor(str));
              i = 0;
            }
          }
          continue;
          label131:
          if (("]".equals(str)) || (".".equals(str))) {
            break;
          }
          this.processors.add(new FieldValueProcessor(str));
        }
      }
    }
  }
  
  private void setValue(Object paramObject1, Object paramObject2)
  {
    loadProcessors();
    if ((this.processors == null) || (this.processors.size() == 0)) {
      return;
    }
    Iterator localIterator = this.processors.iterator();
    Object localObject2 = paramObject1;
    Object localObject1 = paramObject1;
    paramObject1 = localObject2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject1 = (AbsValueProcessor)localIterator.next();
        try
        {
          localObject1 = ((AbsValueProcessor)localObject1).getObjectValue(paramObject1);
          localObject2 = paramObject1;
          paramObject1 = localObject1;
          localObject1 = localObject2;
        }
        catch (NullPointerException localNullPointerException)
        {
          DittoLog.e("DITTO_UI", "current template is accessing field of null value, tpl:" + this.fieldName, new RuntimeException());
        }
      }
    }
    for (;;)
    {
      AbsValueProcessor localAbsValueProcessor = (AbsValueProcessor)this.processors.get(this.processors.size() - 1);
      if ((localAbsValueProcessor == null) || (paramObject1 == null)) {
        break;
      }
      localAbsValueProcessor.setValue(paramObject1, paramObject2);
      return;
      paramObject1 = localAbsValueProcessor;
    }
  }
  
  public Object getValue(Object paramObject)
  {
    loadProcessors();
    Iterator localIterator = this.processors.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject = (AbsValueProcessor)localIterator.next();
        try
        {
          localObject = ((AbsValueProcessor)localObject).getObjectValue(paramObject);
          paramObject = localObject;
        }
        catch (NullPointerException localNullPointerException)
        {
          DittoLog.e("DITTO_UI", "current template is accessing field of null value, tpl:" + this.fieldName, new RuntimeException());
        }
      }
    }
    return paramObject;
  }
  
  public void setValue(Object paramObject, String paramString)
  {
    setValue(paramObject, paramString);
  }
  
  public void setValue(Object paramObject, boolean paramBoolean)
  {
    setValue(paramObject, Boolean.valueOf(paramBoolean));
  }
  
  abstract class AbsValueProcessor
  {
    private AbsValueProcessor() {}
    
    public abstract Object getObjectValue(Object paramObject);
    
    public abstract void setValue(Object paramObject1, Object paramObject2);
  }
  
  class FieldValueProcessor
    extends DittoFieldValue.AbsValueProcessor
  {
    private String innerFieldName;
    
    public FieldValueProcessor(String paramString)
    {
      super(null);
      this.innerFieldName = paramString;
    }
    
    public Object getObjectValue(Object paramObject)
    {
      if ("GLOBAL".equals(this.innerFieldName)) {
        return DittoValue.GLOBAL.getInstance();
      }
      try
      {
        Object localObject = paramObject.getClass().getDeclaredField(this.innerFieldName);
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(paramObject);
        return localObject;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Method localMethod = paramObject.getClass().getDeclaredMethod(this.innerFieldName, new Class[0]);
        localMethod.setAccessible(true);
        paramObject = localMethod.invoke(paramObject, new Object[0]);
        return paramObject;
      }
      catch (NullPointerException paramObject)
      {
        throw paramObject;
      }
      catch (Exception paramObject)
      {
        DittoLog.e("DITTO_UI", "mvc err, getting:" + DittoFieldValue.this.fieldName, paramObject);
      }
      return null;
    }
    
    public void setValue(Object paramObject1, Object paramObject2)
    {
      if ("GLOBAL".equals(this.innerFieldName))
      {
        DittoLog.e("DITTO_UI", "trying to set value of a constant tpl:" + DittoFieldValue.this.fieldName, new RuntimeException());
        return;
      }
      try
      {
        Field localField = paramObject1.getClass().getDeclaredField(this.innerFieldName);
        localField.setAccessible(true);
        localField.set(paramObject1, paramObject2);
        return;
      }
      catch (NullPointerException paramObject1)
      {
        throw paramObject1;
      }
      catch (Exception paramObject1)
      {
        DittoLog.e("DITTO_UI", "mvc err, getting:" + DittoFieldValue.this.fieldName, paramObject1);
      }
    }
  }
  
  class ListValueProcessor
    extends DittoFieldValue.AbsValueProcessor
  {
    private Integer idx;
    
    public ListValueProcessor(Integer paramInteger)
    {
      super(null);
      this.idx = paramInteger;
    }
    
    public Object getObjectValue(Object paramObject)
    {
      if (((paramObject instanceof List)) && (this.idx.intValue() < ((List)paramObject).size()) && (this.idx.intValue() >= 0)) {
        return ((List)paramObject).get(this.idx.intValue());
      }
      return null;
    }
    
    public void setValue(Object paramObject1, Object paramObject2)
    {
      if (((paramObject1 instanceof List)) && (this.idx.intValue() < ((List)paramObject1).size()) && (this.idx.intValue() >= 0)) {
        ((List)paramObject1).set(this.idx.intValue(), paramObject2);
      }
    }
  }
  
  class MapValueProcessor
    extends DittoFieldValue.AbsValueProcessor
  {
    private String key;
    
    public MapValueProcessor(String paramString)
    {
      super(null);
      this.key = paramString;
    }
    
    public Object getObjectValue(Object paramObject)
    {
      if ((paramObject instanceof Map)) {
        return ((Map)paramObject).get(this.key);
      }
      return null;
    }
    
    public void setValue(Object paramObject1, Object paramObject2)
    {
      if ((paramObject1 instanceof Map)) {
        ((Map)paramObject1).put(this.key, paramObject2);
      }
    }
  }
  
  class StringValueProcessor
    extends DittoFieldValue.AbsValueProcessor
  {
    private String value;
    
    public StringValueProcessor(String paramString)
    {
      super(null);
      this.value = paramString;
    }
    
    public Object getObjectValue(Object paramObject)
    {
      return this.value;
    }
    
    public void setValue(Object paramObject1, Object paramObject2)
    {
      DittoLog.e("DITTO_UI", "trying to set value of a constant tpl:" + DittoFieldValue.this.fieldName, new RuntimeException());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ditto.reflect.DittoFieldValue
 * JD-Core Version:    0.7.0.1
 */