package retrofit;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import retrofit.client.Request;
import retrofit.converter.Converter;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.JSONField;
import retrofit.http.Part;
import retrofit.http.PartMap;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;
import retrofit.mime.FormUrlEncodedTypedOutput;
import retrofit.mime.JSONEncodedTypedOutput;
import retrofit.mime.MultipartTypedOutput;
import retrofit.mime.TypedOutput;
import retrofit.mime.TypedString;

final class RequestBuilder
  implements RequestInterceptor.RequestFacade
{
  private final String apiUrl;
  private TypedOutput body;
  private String contentTypeHeader;
  private final Converter converter;
  private final FormUrlEncodedTypedOutput formBody;
  private List<retrofit.client.Header> headers;
  private final boolean isObservable;
  private final boolean isSynchronous;
  private final JSONEncodedTypedOutput jsonBody;
  private final MultipartTypedOutput multipartBody;
  private final Annotation[] paramAnnotations;
  private StringBuilder queryParams;
  private String relativeUrl;
  private final String requestMethod;
  
  RequestBuilder(String paramString, RestMethodInfo paramRestMethodInfo, Converter paramConverter)
  {
    this.apiUrl = paramString;
    this.converter = paramConverter;
    this.paramAnnotations = paramRestMethodInfo.requestParamAnnotations;
    this.requestMethod = paramRestMethodInfo.requestMethod;
    this.isSynchronous = paramRestMethodInfo.isSynchronous;
    this.isObservable = paramRestMethodInfo.isObservable;
    if (paramRestMethodInfo.headers != null) {
      this.headers = new ArrayList(paramRestMethodInfo.headers);
    }
    this.contentTypeHeader = paramRestMethodInfo.contentTypeHeader;
    this.relativeUrl = paramRestMethodInfo.requestUrl;
    paramString = paramRestMethodInfo.requestQuery;
    if (paramString != null) {
      this.queryParams = new StringBuilder().append('?').append(paramString);
    }
    switch (1.$SwitchMap$retrofit$RestMethodInfo$RequestType[paramRestMethodInfo.requestType.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unknown request type: " + paramRestMethodInfo.requestType);
    case 1: 
      this.formBody = new FormUrlEncodedTypedOutput();
      this.jsonBody = null;
      this.multipartBody = null;
      this.body = this.formBody;
      return;
    case 2: 
      this.formBody = null;
      this.jsonBody = new JSONEncodedTypedOutput();
      this.multipartBody = null;
      this.body = this.jsonBody;
      return;
    case 3: 
      this.formBody = null;
      this.jsonBody = null;
      this.multipartBody = new MultipartTypedOutput();
      this.body = this.multipartBody;
      return;
    }
    this.formBody = null;
    this.multipartBody = null;
    this.jsonBody = null;
  }
  
  private void addPathParam(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Path replacement name must not be null.");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("Path replacement \"" + paramString1 + "\" value must not be null.");
    }
    if (paramBoolean) {}
    try
    {
      String str = URLEncoder.encode(String.valueOf(paramString2), "UTF-8").replace("+", "%20");
      this.relativeUrl = this.relativeUrl.replace("{" + paramString1 + "}", str);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("Unable to convert path parameter \"" + paramString1 + "\" value to UTF-8:" + paramString2, localUnsupportedEncodingException);
    }
    this.relativeUrl = this.relativeUrl.replace("{" + paramString1 + "}", String.valueOf(paramString2));
  }
  
  private void addQueryParam(String paramString, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if ((paramObject instanceof Iterable))
    {
      paramObject = ((Iterable)paramObject).iterator();
      while (paramObject.hasNext())
      {
        localObject = paramObject.next();
        if (localObject != null) {
          addQueryParam(paramString, localObject.toString(), paramBoolean1, paramBoolean2);
        }
      }
    }
    if (paramObject.getClass().isArray())
    {
      int i = 0;
      int j = Array.getLength(paramObject);
      while (i < j)
      {
        localObject = Array.get(paramObject, i);
        if (localObject != null) {
          addQueryParam(paramString, localObject.toString(), paramBoolean1, paramBoolean2);
        }
        i += 1;
      }
    }
    addQueryParam(paramString, paramObject.toString(), paramBoolean1, paramBoolean2);
  }
  
  private void addQueryParam(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Query param name must not be null.");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("Query param \"" + paramString1 + "\" value must not be null.");
    }
    Object localObject = paramString1;
    String str2 = paramString2;
    try
    {
      StringBuilder localStringBuilder = this.queryParams;
      if (localStringBuilder == null)
      {
        localObject = paramString1;
        str2 = paramString2;
        localStringBuilder = new StringBuilder();
        localObject = paramString1;
        str2 = paramString2;
        this.queryParams = localStringBuilder;
      }
      for (;;)
      {
        localObject = paramString1;
        str2 = paramString2;
        if (localStringBuilder.length() > 0) {}
        for (char c = '&';; c = '?')
        {
          localObject = paramString1;
          str2 = paramString2;
          localStringBuilder.append(c);
          String str1 = paramString1;
          if (paramBoolean1)
          {
            localObject = paramString1;
            str2 = paramString2;
            str1 = URLEncoder.encode(paramString1, "UTF-8");
          }
          paramString1 = paramString2;
          if (paramBoolean2)
          {
            localObject = str1;
            str2 = paramString2;
            paramString1 = URLEncoder.encode(paramString2, "UTF-8");
          }
          localObject = str1;
          str2 = paramString1;
          localStringBuilder.append(str1).append('=').append(paramString1);
          return;
        }
      }
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new RuntimeException("Unable to convert query parameter \"" + (String)localObject + "\" value to UTF-8: " + str2, paramString1);
    }
  }
  
  private void addQueryParamMap(int paramInt, Map<?, ?> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (Map.Entry)paramMap.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      if (localObject1 == null) {
        throw new IllegalArgumentException("Parameter #" + (paramInt + 1) + " query map contained null key.");
      }
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (localObject2 != null) {
        addQueryParam(localObject1.toString(), localObject2.toString(), paramBoolean1, paramBoolean2);
      }
    }
  }
  
  public void addEncodedPathParam(String paramString1, String paramString2)
  {
    addPathParam(paramString1, paramString2, false);
  }
  
  public void addEncodedQueryParam(String paramString1, String paramString2)
  {
    addQueryParam(paramString1, paramString2, false, false);
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Header name must not be null.");
    }
    if ("Content-Type".equalsIgnoreCase(paramString1))
    {
      this.contentTypeHeader = paramString2;
      return;
    }
    List localList = this.headers;
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList(2);
      this.headers = ((List)localObject);
    }
    ((List)localObject).add(new retrofit.client.Header(paramString1, paramString2));
  }
  
  public void addPathParam(String paramString1, String paramString2)
  {
    addPathParam(paramString1, paramString2, true);
  }
  
  public void addQueryParam(String paramString1, String paramString2)
  {
    addQueryParam(paramString1, paramString2, false, true);
  }
  
  Request build()
    throws UnsupportedEncodingException
  {
    if ((this.multipartBody != null) && (this.multipartBody.getPartCount() == 0)) {
      throw new IllegalStateException("Multipart requests must contain at least one part.");
    }
    Object localObject = this.apiUrl;
    StringBuilder localStringBuilder = new StringBuilder((String)localObject);
    if (((String)localObject).endsWith("/")) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    localStringBuilder.append(this.relativeUrl);
    localObject = this.queryParams;
    if (localObject != null) {
      localStringBuilder.append((CharSequence)localObject);
    }
    localObject = this.body;
    List localList = this.headers;
    if (this.contentTypeHeader != null) {
      if (localObject != null) {
        localObject = new MimeOverridingTypedOutput((TypedOutput)localObject, this.contentTypeHeader);
      }
    }
    for (;;)
    {
      return new Request(this.requestMethod, localStringBuilder.toString(), localList, (TypedOutput)localObject);
      retrofit.client.Header localHeader = new retrofit.client.Header("Content-Type", this.contentTypeHeader);
      if (localList == null) {
        localList = Collections.singletonList(localHeader);
      } else {
        localList.add(localHeader);
      }
    }
  }
  
  void setArguments(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return;
    }
    int i = paramArrayOfObject.length;
    if ((!this.isSynchronous) && (!this.isObservable)) {
      i -= 1;
    }
    for (;;)
    {
      int j = 0;
      label28:
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (j < i)
      {
        localObject1 = paramArrayOfObject[j];
        localObject2 = this.paramAnnotations[j];
        localObject3 = ((Annotation)localObject2).annotationType();
        if (localObject3 != Path.class) {
          break label143;
        }
        localObject2 = (Path)localObject2;
        localObject3 = ((Path)localObject2).value();
        if (localObject1 == null) {
          throw new IllegalArgumentException("Path parameter \"" + (String)localObject3 + "\" value must not be null.");
        }
        addPathParam((String)localObject3, localObject1.toString(), ((Path)localObject2).encode());
      }
      for (;;)
      {
        j += 1;
        break label28;
        break;
        label143:
        if (localObject3 == Query.class)
        {
          if (localObject1 != null)
          {
            localObject2 = (Query)localObject2;
            addQueryParam(((Query)localObject2).value(), localObject1, ((Query)localObject2).encodeName(), ((Query)localObject2).encodeValue());
          }
        }
        else if (localObject3 == QueryMap.class)
        {
          if (localObject1 != null)
          {
            localObject2 = (QueryMap)localObject2;
            addQueryParamMap(j, (Map)localObject1, ((QueryMap)localObject2).encodeNames(), ((QueryMap)localObject2).encodeValues());
          }
        }
        else
        {
          int m;
          int k;
          if (localObject3 == retrofit.http.Header.class)
          {
            if (localObject1 != null)
            {
              localObject2 = ((retrofit.http.Header)localObject2).value();
              if ((localObject1 instanceof Iterable))
              {
                localObject1 = ((Iterable)localObject1).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject3 = ((Iterator)localObject1).next();
                  if (localObject3 != null) {
                    addHeader((String)localObject2, localObject3.toString());
                  }
                }
              }
              else if (localObject1.getClass().isArray())
              {
                m = Array.getLength(localObject1);
                k = 0;
                while (k < m)
                {
                  localObject3 = Array.get(localObject1, k);
                  if (localObject3 != null) {
                    addHeader((String)localObject2, localObject3.toString());
                  }
                  k += 1;
                }
              }
              else
              {
                addHeader((String)localObject2, localObject1.toString());
              }
            }
          }
          else
          {
            boolean bool1;
            boolean bool2;
            if (localObject3 == Field.class)
            {
              if (localObject1 != null)
              {
                localObject3 = (Field)localObject2;
                localObject2 = ((Field)localObject3).value();
                bool1 = ((Field)localObject3).encodeName();
                bool2 = ((Field)localObject3).encodeValue();
                if ((localObject1 instanceof Iterable))
                {
                  localObject1 = ((Iterable)localObject1).iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    localObject3 = ((Iterator)localObject1).next();
                    if (localObject3 != null) {
                      this.formBody.addField((String)localObject2, bool1, localObject3.toString(), bool2);
                    }
                  }
                }
                else if (localObject1.getClass().isArray())
                {
                  m = Array.getLength(localObject1);
                  k = 0;
                  while (k < m)
                  {
                    localObject3 = Array.get(localObject1, k);
                    if (localObject3 != null) {
                      this.formBody.addField((String)localObject2, bool1, localObject3.toString(), bool2);
                    }
                    k += 1;
                  }
                }
                else
                {
                  this.formBody.addField((String)localObject2, bool1, localObject1.toString(), bool2);
                }
              }
            }
            else if (localObject3 == JSONField.class)
            {
              localObject2 = ((JSONField)localObject2).value();
              this.jsonBody.addField((String)localObject2, false, localObject1, false);
            }
            else if (localObject3 == Field.class)
            {
              if (localObject1 != null)
              {
                localObject3 = (Field)localObject2;
                localObject2 = ((Field)localObject3).value();
                bool1 = ((Field)localObject3).encodeName();
                bool2 = ((Field)localObject3).encodeValue();
                if ((localObject1 instanceof Iterable))
                {
                  localObject1 = ((Iterable)localObject1).iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    localObject3 = ((Iterator)localObject1).next();
                    if (localObject3 != null) {
                      this.formBody.addField((String)localObject2, bool1, localObject3.toString(), bool2);
                    }
                  }
                }
                else if (localObject1.getClass().isArray())
                {
                  m = Array.getLength(localObject1);
                  k = 0;
                  while (k < m)
                  {
                    localObject3 = Array.get(localObject1, k);
                    if (localObject3 != null) {
                      this.formBody.addField((String)localObject2, bool1, localObject3.toString(), bool2);
                    }
                    k += 1;
                  }
                }
                else
                {
                  this.formBody.addField((String)localObject2, bool1, localObject1.toString(), bool2);
                }
              }
            }
            else if (localObject3 == FieldMap.class)
            {
              if (localObject1 != null)
              {
                localObject2 = (FieldMap)localObject2;
                bool1 = ((FieldMap)localObject2).encodeNames();
                bool2 = ((FieldMap)localObject2).encodeValues();
                localObject1 = ((Map)localObject1).entrySet().iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject3 = (Map.Entry)((Iterator)localObject1).next();
                  localObject2 = ((Map.Entry)localObject3).getKey();
                  if (localObject2 == null) {
                    throw new IllegalArgumentException("Parameter #" + (j + 1) + " field map contained null key.");
                  }
                  localObject3 = ((Map.Entry)localObject3).getValue();
                  if (localObject3 != null) {
                    this.formBody.addField(localObject2.toString(), bool1, localObject3.toString(), bool2);
                  }
                }
              }
            }
            else if (localObject3 == Part.class)
            {
              if (localObject1 != null)
              {
                localObject3 = ((Part)localObject2).value();
                localObject2 = ((Part)localObject2).encoding();
                if ((localObject1 instanceof TypedOutput)) {
                  this.multipartBody.addPart((String)localObject3, (String)localObject2, (TypedOutput)localObject1);
                } else if ((localObject1 instanceof String)) {
                  this.multipartBody.addPart((String)localObject3, (String)localObject2, new TypedString((String)localObject1));
                } else {
                  this.multipartBody.addPart((String)localObject3, (String)localObject2, this.converter.toBody(localObject1));
                }
              }
            }
            else if (localObject3 == PartMap.class)
            {
              if (localObject1 != null)
              {
                localObject2 = ((PartMap)localObject2).encoding();
                localObject1 = ((Map)localObject1).entrySet().iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject3 = (Map.Entry)((Iterator)localObject1).next();
                  Object localObject4 = ((Map.Entry)localObject3).getKey();
                  if (localObject4 == null) {
                    throw new IllegalArgumentException("Parameter #" + (j + 1) + " part map contained null key.");
                  }
                  localObject4 = localObject4.toString();
                  localObject3 = ((Map.Entry)localObject3).getValue();
                  if (localObject3 != null) {
                    if ((localObject3 instanceof TypedOutput)) {
                      this.multipartBody.addPart((String)localObject4, (String)localObject2, (TypedOutput)localObject3);
                    } else if ((localObject3 instanceof String)) {
                      this.multipartBody.addPart((String)localObject4, (String)localObject2, new TypedString((String)localObject3));
                    } else {
                      this.multipartBody.addPart((String)localObject4, (String)localObject2, this.converter.toBody(localObject3));
                    }
                  }
                }
              }
            }
            else
            {
              if (localObject3 != Body.class) {
                break label1408;
              }
              if (localObject1 == null) {
                throw new IllegalArgumentException("Body parameter value must not be null.");
              }
              if ((localObject1 instanceof TypedOutput)) {
                this.body = ((TypedOutput)localObject1);
              } else {
                this.body = this.converter.toBody(localObject1);
              }
            }
          }
        }
      }
      label1408:
      throw new IllegalArgumentException("Unknown annotation: " + ((Class)localObject3).getCanonicalName());
    }
  }
  
  static class MimeOverridingTypedOutput
    implements TypedOutput
  {
    private final TypedOutput delegate;
    private final String mimeType;
    
    MimeOverridingTypedOutput(TypedOutput paramTypedOutput, String paramString)
    {
      this.delegate = paramTypedOutput;
      this.mimeType = paramString;
    }
    
    public String fileName()
    {
      return this.delegate.fileName();
    }
    
    public long length()
    {
      return this.delegate.length();
    }
    
    public String mimeType()
    {
      return this.mimeType;
    }
    
    public void writeTo(OutputStream paramOutputStream)
      throws IOException
    {
      this.delegate.writeTo(paramOutputStream);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.RequestBuilder
 * JD-Core Version:    0.7.0.1
 */