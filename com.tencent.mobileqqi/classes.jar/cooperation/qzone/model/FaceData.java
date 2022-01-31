package cooperation.qzone.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import ihe;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ihe();
  private static final int b = 1;
  public int a;
  public long a;
  public Bitmap a;
  public String a;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public String f;
  public long g = 0L;
  public long h = 0L;
  
  public FaceData()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
  }
  
  public static String a(ArrayList paramArrayList)
  {
    JSONArray localJSONArray = new JSONArray();
    for (;;)
    {
      FaceData localFaceData;
      try
      {
        Iterator localIterator = paramArrayList.iterator();
        if (localIterator.hasNext())
        {
          localFaceData = (FaceData)localIterator.next();
          if (TextUtils.isEmpty(localFaceData.jdField_a_of_type_JavaLangString) == true)
          {
            paramArrayList = "";
            if (TextUtils.isEmpty(localFaceData.jdField_b_of_type_JavaLangString) != true) {
              break label342;
            }
            str1 = "";
            if (TextUtils.isEmpty(localFaceData.jdField_c_of_type_JavaLangString) != true) {
              break label351;
            }
            str2 = "";
            if (TextUtils.isEmpty(localFaceData.jdField_d_of_type_JavaLangString) != true) {
              break label360;
            }
            str3 = "";
            if (TextUtils.isEmpty(localFaceData.jdField_e_of_type_JavaLangString) != true) {
              break label369;
            }
            str4 = "";
            if (TextUtils.isEmpty(localFaceData.jdField_f_of_type_JavaLangString) != true) {
              break label379;
            }
            str5 = "";
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("aid", paramArrayList);
            localJSONObject.put("pid", str1);
            localJSONObject.put("oin", localFaceData.jdField_a_of_type_Long);
            localJSONObject.put("x", localFaceData.jdField_b_of_type_Long);
            localJSONObject.put("y", localFaceData.jdField_c_of_type_Long);
            localJSONObject.put("w", localFaceData.jdField_d_of_type_Long);
            localJSONObject.put("h", localFaceData.jdField_e_of_type_Long);
            localJSONObject.put("qte", localFaceData.jdField_a_of_type_Int);
            localJSONObject.put("ome", localFaceData.jdField_f_of_type_Long);
            localJSONObject.put("fid", str2);
            localJSONObject.put("qid", str3);
            localJSONObject.put("tin", localFaceData.g);
            localJSONObject.put("tck", str4);
            localJSONObject.put("win", localFaceData.h);
            localJSONObject.put("wck", str5);
            localJSONArray.put(localJSONObject);
          }
        }
        else
        {
          return localJSONArray.toString();
        }
      }
      catch (JSONException paramArrayList)
      {
        paramArrayList.printStackTrace();
      }
      paramArrayList = localFaceData.jdField_a_of_type_JavaLangString;
      continue;
      label342:
      String str1 = localFaceData.jdField_b_of_type_JavaLangString;
      continue;
      label351:
      String str2 = localFaceData.jdField_c_of_type_JavaLangString;
      continue;
      label360:
      String str3 = localFaceData.jdField_d_of_type_JavaLangString;
      continue;
      label369:
      String str4 = localFaceData.jdField_e_of_type_JavaLangString;
      continue;
      label379:
      String str5 = localFaceData.jdField_f_of_type_JavaLangString;
    }
  }
  
  public static ArrayList a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramString == null) || ("".equals(paramString))) {
      return localArrayList;
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        int i = 0;
        if (i < localJSONArray.length())
        {
          localObject = (JSONObject)localJSONArray.get(i);
          if (!((JSONObject)localObject).has("aid")) {
            break label560;
          }
          paramString = ((JSONObject)localObject).getString("aid");
          if (!((JSONObject)localObject).has("pid")) {
            break label553;
          }
          str1 = ((JSONObject)localObject).getString("pid");
          if (!((JSONObject)localObject).has("oin")) {
            break label548;
          }
          l1 = ((JSONObject)localObject).getLong("oin");
          if (!((JSONObject)localObject).has("x")) {
            break label542;
          }
          l2 = ((JSONObject)localObject).getLong("x");
          if (!((JSONObject)localObject).has("y")) {
            break label536;
          }
          l3 = ((JSONObject)localObject).getLong("y");
          if (!((JSONObject)localObject).has("w")) {
            break label530;
          }
          l4 = ((JSONObject)localObject).getLong("w");
          if (!((JSONObject)localObject).has("h")) {
            break label524;
          }
          l5 = ((JSONObject)localObject).getLong("h");
          if (!((JSONObject)localObject).has("qte")) {
            break label519;
          }
          j = ((JSONObject)localObject).getInt("qte");
          if (!((JSONObject)localObject).has("ome")) {
            break label513;
          }
          l6 = ((JSONObject)localObject).getLong("ome");
          if (!((JSONObject)localObject).has("fid")) {
            break label506;
          }
          str2 = ((JSONObject)localObject).getString("fid");
          if (!((JSONObject)localObject).has("qid")) {
            break label499;
          }
          str3 = ((JSONObject)localObject).getString("qid");
          if (!((JSONObject)localObject).has("tin")) {
            break label493;
          }
          l7 = ((JSONObject)localObject).getLong("tin");
          if (!((JSONObject)localObject).has("tck")) {
            break label486;
          }
          str4 = ((JSONObject)localObject).getString("tck");
          if (!((JSONObject)localObject).has("win")) {
            break label480;
          }
          l8 = ((JSONObject)localObject).getLong("win");
          if (((JSONObject)localObject).has("wck"))
          {
            localObject = ((JSONObject)localObject).getString("wck");
            FaceData localFaceData = new FaceData();
            localFaceData.jdField_a_of_type_JavaLangString = paramString;
            localFaceData.jdField_b_of_type_JavaLangString = str1;
            localFaceData.jdField_a_of_type_Long = l1;
            localFaceData.jdField_b_of_type_Long = l2;
            localFaceData.jdField_c_of_type_Long = l3;
            localFaceData.jdField_d_of_type_Long = l4;
            localFaceData.jdField_e_of_type_Long = l5;
            localFaceData.jdField_a_of_type_Int = j;
            localFaceData.jdField_f_of_type_Long = l6;
            localFaceData.jdField_c_of_type_JavaLangString = str2;
            localFaceData.jdField_d_of_type_JavaLangString = str3;
            localFaceData.g = l7;
            localFaceData.jdField_e_of_type_JavaLangString = str4;
            localFaceData.h = l8;
            localFaceData.jdField_f_of_type_JavaLangString = ((String)localObject);
            localArrayList.add(localFaceData);
            i += 1;
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      Object localObject = "";
      continue;
      label480:
      long l8 = 0L;
      continue;
      label486:
      String str4 = "";
      continue;
      label493:
      long l7 = 0L;
      continue;
      label499:
      String str3 = "";
      continue;
      label506:
      String str2 = "";
      continue;
      label513:
      long l6 = 0L;
      continue;
      label519:
      int j = 0;
      continue;
      label524:
      long l5 = 0L;
      continue;
      label530:
      long l4 = 0L;
      continue;
      label536:
      long l3 = 0L;
      continue;
      label542:
      long l2 = 0L;
      continue;
      label548:
      long l1 = 0L;
      continue;
      label553:
      String str1 = "";
      continue;
      label560:
      paramString = "";
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeLong(this.jdField_e_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_f_of_type_Long);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeLong(this.g);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeLong(this.h);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.model.FaceData
 * JD-Core Version:    0.7.0.1
 */