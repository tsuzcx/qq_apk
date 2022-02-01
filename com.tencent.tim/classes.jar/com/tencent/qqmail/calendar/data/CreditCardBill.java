package com.tencent.qqmail.calendar.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class CreditCardBill
  implements Parcelable
{
  public static final Parcelable.Creator<CreditCardBill> CREATOR = new CreditCardBill.1();
  public String allPayAmount;
  public String bank;
  public String date;
  public String from;
  public String mailId;
  public String minPayAmount;
  public boolean mutiCurrencyBill;
  public String num;
  public String owner;
  public String payed;
  public String result;
  public String scheduleId;
  public String url;
  
  public CreditCardBill() {}
  
  protected CreditCardBill(Parcel paramParcel)
  {
    this.bank = paramParcel.readString();
    this.date = paramParcel.readString();
    this.allPayAmount = paramParcel.readString();
    this.minPayAmount = paramParcel.readString();
    this.from = paramParcel.readString();
    this.num = paramParcel.readString();
    this.owner = paramParcel.readString();
    this.payed = paramParcel.readString();
    this.result = paramParcel.readString();
    this.mailId = paramParcel.readString();
    this.scheduleId = paramParcel.readString();
    this.url = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mutiCurrencyBill = bool;
      return;
    }
  }
  
  public static CreditCardBill parse(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    CreditCardBill localCreditCardBill = new CreditCardBill();
    localCreditCardBill.bank = paramJSONObject.getString("b");
    localCreditCardBill.date = parsetDate(paramJSONObject.getString("d"));
    localCreditCardBill.from = paramJSONObject.getString("f");
    localCreditCardBill.num = paramJSONObject.getString("n");
    localCreditCardBill.owner = paramJSONObject.getString("o");
    localCreditCardBill.payed = paramJSONObject.getString("p");
    localCreditCardBill.result = paramJSONObject.getString("ret");
    localCreditCardBill.scheduleId = paramJSONObject.getString("i");
    localCreditCardBill.mailId = paramJSONObject.getString("m");
    localCreditCardBill.url = ("https://mail.qq.com/bill/g/" + paramJSONObject.getString("u"));
    parseCurrencyType(paramJSONObject.getJSONArray("bl"), localCreditCardBill);
    return localCreditCardBill;
  }
  
  private static void parseCurrencyType(JSONArray paramJSONArray, CreditCardBill paramCreditCardBill)
  {
    boolean bool = false;
    if ((paramJSONArray == null) || (paramCreditCardBill == null)) {
      return;
    }
    String str1 = "";
    String str2 = "";
    int i = 0;
    if (i < paramJSONArray.size())
    {
      JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
      String str3 = localJSONObject.getString("u");
      Object localObject1 = "";
      Object localObject2 = localObject1;
      if (paramJSONArray.size() > 1)
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(str3)) {
          localObject2 = " (" + str3 + ")";
        }
      }
      Object localObject3 = localJSONObject.getString("up");
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        if (!"人民币".equalsIgnoreCase(str3)) {
          break label283;
        }
      }
      label283:
      for (localObject1 = "¥";; localObject1 = "＄")
      {
        localObject3 = localObject1;
        if (i != 0) {
          localObject3 = "\n" + (String)localObject1;
        }
        localObject1 = (String)localObject3 + localJSONObject.getString("al") + (String)localObject2;
        localObject2 = (String)localObject3 + localJSONObject.getString("mi") + (String)localObject2;
        str2 = str2 + (String)localObject1;
        str1 = str1 + (String)localObject2;
        i += 1;
        break;
      }
    }
    if (paramJSONArray.size() > 1) {
      bool = true;
    }
    paramCreditCardBill.mutiCurrencyBill = bool;
    paramCreditCardBill.allPayAmount = str2;
    paramCreditCardBill.minPayAmount = str1;
  }
  
  public static String parsetDate(@NonNull String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() != 10)) {
      return paramString;
    }
    String str = paramString.substring(5, 7);
    paramString = paramString.substring(8, 10);
    return str + "月" + paramString + "日";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "CreditCardBill{bank='" + this.bank + '\'' + ", date='" + this.date + '\'' + ", allPayAmount='" + this.allPayAmount + '\'' + ", minPayAmount='" + this.minPayAmount + '\'' + ", from='" + this.from + '\'' + ", num='" + this.num + '\'' + ", owner='" + this.owner + '\'' + ", payed='" + this.payed + '\'' + ", result='" + this.result + '\'' + ", mailId='" + this.mailId + '\'' + ", scheduleId='" + this.scheduleId + '\'' + ", url='" + this.url + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.bank);
    paramParcel.writeString(this.date);
    paramParcel.writeString(this.allPayAmount);
    paramParcel.writeString(this.minPayAmount);
    paramParcel.writeString(this.from);
    paramParcel.writeString(this.num);
    paramParcel.writeString(this.owner);
    paramParcel.writeString(this.payed);
    paramParcel.writeString(this.result);
    paramParcel.writeString(this.mailId);
    paramParcel.writeString(this.scheduleId);
    paramParcel.writeString(this.url);
    if (this.mutiCurrencyBill) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.CreditCardBill
 * JD-Core Version:    0.7.0.1
 */