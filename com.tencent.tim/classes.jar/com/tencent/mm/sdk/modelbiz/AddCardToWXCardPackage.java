package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class AddCardToWXCardPackage
{
  public static class Req
    extends BaseReq
  {
    public List<AddCardToWXCardPackage.WXCardItem> cardArrary;
    
    public boolean checkArgs()
    {
      if ((this.cardArrary == null) || (this.cardArrary.size() == 0) || (this.cardArrary.size() > 40)) {
        return false;
      }
      Iterator localIterator = this.cardArrary.iterator();
      while (localIterator.hasNext())
      {
        AddCardToWXCardPackage.WXCardItem localWXCardItem = (AddCardToWXCardPackage.WXCardItem)localIterator.next();
        if ((localWXCardItem == null) || (localWXCardItem.cardId == null) || (localWXCardItem.cardId.length() > 1024) || ((localWXCardItem.cardExtMsg != null) && (localWXCardItem.cardExtMsg.length() > 1024))) {
          return false;
        }
      }
      return true;
    }
    
    public int getType()
    {
      return 9;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      JSONStringer localJSONStringer = new JSONStringer();
      try
      {
        localJSONStringer.object();
        localJSONStringer.key("card_list");
        localJSONStringer.array();
        Iterator localIterator = this.cardArrary.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            Object localObject = (AddCardToWXCardPackage.WXCardItem)localIterator.next();
            localJSONStringer.object();
            localJSONStringer.key("card_id");
            localJSONStringer.value(((AddCardToWXCardPackage.WXCardItem)localObject).cardId);
            localJSONStringer.key("card_ext");
            if (((AddCardToWXCardPackage.WXCardItem)localObject).cardExtMsg == null)
            {
              localObject = "";
              localJSONStringer.value(localObject);
              localJSONStringer.endObject();
              continue;
              paramBundle.putString("_wxapi_add_card_to_wx_card_list", localJSONStringer.toString());
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      for (;;)
      {
        return;
        String str = localException.cardExtMsg;
        break;
        localJSONStringer.endArray();
        localJSONStringer.endObject();
      }
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public List<AddCardToWXCardPackage.WXCardItem> cardArrary;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    public boolean checkArgs()
    {
      return (this.cardArrary != null) && (this.cardArrary.size() != 0);
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      if (this.cardArrary == null) {
        this.cardArrary = new LinkedList();
      }
      paramBundle = paramBundle.getString("_wxapi_add_card_to_wx_card_list");
      if ((paramBundle != null) && (paramBundle.length() > 0)) {
        try
        {
          paramBundle = ((JSONObject)new JSONTokener(paramBundle).nextValue()).getJSONArray("card_list");
          int i = 0;
          while (i < paramBundle.length())
          {
            JSONObject localJSONObject = paramBundle.getJSONObject(i);
            AddCardToWXCardPackage.WXCardItem localWXCardItem = new AddCardToWXCardPackage.WXCardItem();
            localWXCardItem.cardId = localJSONObject.optString("card_id");
            localWXCardItem.cardExtMsg = localJSONObject.optString("card_ext");
            localWXCardItem.cardState = localJSONObject.optInt("is_succ");
            this.cardArrary.add(localWXCardItem);
            i += 1;
          }
          return;
        }
        catch (Exception paramBundle) {}
      }
    }
    
    public int getType()
    {
      return 9;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      JSONStringer localJSONStringer = new JSONStringer();
      AddCardToWXCardPackage.WXCardItem localWXCardItem;
      try
      {
        localJSONStringer.object();
        localJSONStringer.key("card_list");
        localJSONStringer.array();
        Iterator localIterator = this.cardArrary.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localWXCardItem = (AddCardToWXCardPackage.WXCardItem)localIterator.next();
            localJSONStringer.object();
            localJSONStringer.key("card_id");
            localJSONStringer.value(localWXCardItem.cardId);
            localJSONStringer.key("card_ext");
            if (localWXCardItem.cardExtMsg == null)
            {
              String str1 = "";
              localJSONStringer.value(str1);
              localJSONStringer.key("is_succ");
              localJSONStringer.value(localWXCardItem.cardState);
              localJSONStringer.endObject();
              continue;
              paramBundle.putString("_wxapi_add_card_to_wx_card_list", localJSONStringer.toString());
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      for (;;)
      {
        return;
        String str2 = localWXCardItem.cardExtMsg;
        break;
        localJSONStringer.endArray();
        localJSONStringer.endObject();
      }
    }
  }
  
  public static final class WXCardItem
  {
    public String cardExtMsg;
    public String cardId;
    public int cardState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.modelbiz.AddCardToWXCardPackage
 * JD-Core Version:    0.7.0.1
 */