import com.tencent.ims.signature.SignatureReport;
import com.tencent.ims.signature.SignatureResult;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import org.json.JSONObject;

public class arob
  implements arnw.b
{
  private arnx jdField_a_of_type_Arnx;
  private arob.a jdField_a_of_type_Arob$a;
  
  public arob(arnx paramarnx)
  {
    arnw localarnw = paramarnx.a;
    if (localarnw != null) {
      localarnw.setNetTransportEventListener("sig_check", this);
    }
    this.jdField_a_of_type_Arnx = paramarnx;
  }
  
  public void a(arob.a parama)
  {
    this.jdField_a_of_type_Arob$a = parama;
  }
  
  public void f(Object paramObject1, Object paramObject2)
  {
    if (this.jdField_a_of_type_Arob$a == null) {}
    label7:
    do
    {
      do
      {
        do
        {
          break label7;
          do
          {
            return;
          } while (this.jdField_a_of_type_Arnx == null);
          paramObject1 = this.jdField_a_of_type_Arnx.a;
        } while (paramObject1 == null);
        paramObject1 = paramObject1.getCodec("sig_check");
      } while (paramObject1 == null);
      paramObject1 = (byte[])paramObject1.decode(paramObject2);
    } while (paramObject1 == null);
    Object localObject = new signature.SignatureResult();
    try
    {
      ((signature.SignatureResult)localObject).mergeFrom(paramObject1);
      int i = -1;
      paramObject1 = "";
      paramObject2 = "";
      String str1 = "";
      String str2 = "";
      String str3 = "";
      int j = 604800;
      if (((signature.SignatureResult)localObject).u32_check_result.has()) {
        i = ((signature.SignatureResult)localObject).u32_check_result.get();
      }
      if (((signature.SignatureResult)localObject).str_title.has()) {
        paramObject1 = ((signature.SignatureResult)localObject).str_title.get();
      }
      if (((signature.SignatureResult)localObject).str_content.has()) {
        paramObject2 = ((signature.SignatureResult)localObject).str_content.get();
      }
      if (((signature.SignatureResult)localObject).str_left_button.has()) {
        str1 = ((signature.SignatureResult)localObject).str_left_button.get();
      }
      if (((signature.SignatureResult)localObject).str_right_button.has()) {
        str2 = ((signature.SignatureResult)localObject).str_right_button.get();
      }
      if (((signature.SignatureResult)localObject).str_url.has()) {
        str3 = ((signature.SignatureResult)localObject).str_url.get();
      }
      if (((signature.SignatureResult)localObject).u32_cache_time.has()) {
        j = ((signature.SignatureResult)localObject).u32_cache_time.get();
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("dialog_title", paramObject1);
        ((JSONObject)localObject).put("dialog_content", paramObject2);
        ((JSONObject)localObject).put("dialog_left_button", str1);
        ((JSONObject)localObject).put("dialog_right_button", str2);
        ((JSONObject)localObject).put("url", str3);
        paramObject1 = new JSONObject();
        paramObject1.put("sig_check_result", i);
        paramObject1.put("dialog_config", localObject);
        paramObject1.put("cache_time", j);
        this.jdField_a_of_type_Arob$a.uE(paramObject1.toString());
        return;
      }
      catch (Exception paramObject1)
      {
        paramObject1.printStackTrace();
        return;
      }
    }
    catch (Exception paramObject1)
    {
      for (;;)
      {
        paramObject1.printStackTrace();
      }
    }
  }
  
  public void start(String paramString)
  {
    int k = 0;
    int m = 0;
    int i = 0;
    long l3 = 0L;
    Object localObject1 = "";
    Object localObject2 = "";
    String str2 = "";
    long l2 = l3;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        l1 = l3;
        l2 = l3;
        if (localJSONObject.has("uin"))
        {
          l2 = l3;
          l1 = localJSONObject.getLong("uin");
        }
        l2 = l1;
        if (!localJSONObject.has("client_type")) {
          break label558;
        }
        l2 = l1;
        j = localJSONObject.getInt("client_type");
        localObject5 = localObject2;
        localObject3 = localObject1;
        k = m;
      }
      catch (Exception localException1)
      {
        try
        {
          JSONObject localJSONObject;
          Object localObject3;
          if (localJSONObject.has("package_signature"))
          {
            localObject3 = localJSONObject.getString("package_signature");
            l2 = l1;
            m = j;
            k = i;
            str1 = paramString;
            localObject6 = localObject1;
            localObject5 = localObject2;
          }
          paramString = new signature.SignatureReport();
          paramString.u64_uin.set(l2);
          paramString.u32_client_type.set(m);
          paramString.u32_is_repack.set(k);
          paramString.str_packname.set(str1);
          paramString.str_version.set(localObject6);
          paramString.str_md5.set((String)localObject5);
          paramString.str_signature.set((String)localObject3);
          if (this.jdField_a_of_type_Arnx != null) {
            continue;
          }
          return;
        }
        catch (Exception localException2)
        {
          long l1;
          Object localObject5;
          Object localObject6;
          String str1;
          Object localObject4;
          continue;
        }
        localException1 = localException1;
        j = 0;
        localObject5 = "";
        l1 = l2;
        i = k;
        paramString = (String)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject5;
        localException1.printStackTrace();
        localObject4 = str2;
        localObject5 = localObject2;
        localObject6 = localObject1;
        str1 = paramString;
        k = i;
        m = j;
        l2 = l1;
        continue;
        localObject2 = this.jdField_a_of_type_Arnx.a;
        if (localObject2 == null) {
          continue;
        }
        localObject1 = paramString.toByteArray();
        localObject4 = ((arnw)localObject2).getCodec("sig_check");
        paramString = (String)localObject1;
        if (localObject4 != null) {
          paramString = ((arnw.a)localObject4).encode(localObject1);
        }
        ((arnw)localObject2).send(paramString);
        return;
      }
      try
      {
        if (localJSONObject.has("is_repack"))
        {
          localObject5 = localObject2;
          localObject3 = localObject1;
          k = m;
          i = localJSONObject.getInt("is_repack");
        }
        paramString = (String)localObject1;
        localObject5 = localObject2;
        localObject3 = localObject1;
        k = i;
        if (localJSONObject.has("package_name"))
        {
          localObject5 = localObject2;
          localObject3 = localObject1;
          k = i;
          paramString = localJSONObject.getString("package_name");
        }
        localObject1 = localObject2;
        localObject5 = localObject2;
        localObject3 = paramString;
        k = i;
        if (localJSONObject.has("package_version"))
        {
          localObject5 = localObject2;
          localObject3 = paramString;
          k = i;
          localObject1 = localJSONObject.getString("package_version");
        }
        localObject5 = localObject1;
        localObject3 = paramString;
        k = i;
        if (!localJSONObject.has("package_md5")) {
          break label551;
        }
        localObject5 = localObject1;
        localObject3 = paramString;
        k = i;
        localObject2 = localJSONObject.getString("package_md5");
      }
      catch (Exception localException3)
      {
        localObject2 = "";
        localObject1 = localObject5;
        paramString = (String)localObject4;
        i = k;
        localObject4 = localException3;
        continue;
        localObject2 = "";
        continue;
      }
      localObject3 = str2;
      localObject5 = localObject2;
      localObject6 = localObject1;
      str1 = paramString;
      k = i;
      m = j;
      l2 = l1;
      label551:
      label558:
      int j = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void uE(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arob
 * JD-Core Version:    0.7.0.1
 */