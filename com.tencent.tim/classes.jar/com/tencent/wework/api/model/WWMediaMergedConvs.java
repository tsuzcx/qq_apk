package com.tencent.wework.api.model;

import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WWMediaMergedConvs
  extends WWMediaMessage.WWMediaObject
{
  private static final String TAG = "WWAPI.WWMediaConv";
  public List<WWMediaConversation> messages = new ArrayList();
  
  public boolean addItem(WWMediaConversation paramWWMediaConversation)
  {
    if ((paramWWMediaConversation != null) && (paramWWMediaConversation.checkArgs()))
    {
      this.messages.add(paramWWMediaConversation);
      return true;
    }
    return false;
  }
  
  public boolean checkArgs()
  {
    if (!super.checkArgs()) {
      return false;
    }
    if ((this.messages == null) || (this.messages.size() == 0))
    {
      Log.d("WWAPI.WWMediaConv", "checkArgs fail, all arguments are null");
      return false;
    }
    Iterator localIterator = this.messages.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((BaseMessage)localIterator.next()).checkArgs());
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    int j = paramBundle.getInt("_wwmergedconvobject_messageslen");
    int i = 0;
    if (i < j)
    {
      BaseMessage localBaseMessage = BaseMessage.parse(paramBundle.getBundle("_wwmergedconvobject_messages" + i));
      if ((localBaseMessage != null) && ((localBaseMessage instanceof WWMediaConversation))) {
        this.messages.add((WWMediaConversation)localBaseMessage);
      }
      for (;;)
      {
        i += 1;
        break;
        StringBuilder localStringBuilder = new StringBuilder().append("fromBundle ");
        Object localObject = localBaseMessage;
        if (localBaseMessage == null) {
          localObject = "null";
        }
        Log.d("WWAPI.WWMediaConv", localObject);
      }
    }
    super.fromBundle(paramBundle);
  }
  
  public int getType()
  {
    return 9;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putInt("_wwmergedconvobject_messageslen", this.messages.size());
    int i = 0;
    while (i < this.messages.size())
    {
      paramBundle.putBundle("_wwmergedconvobject_messages" + i, BaseMessage.pack((BaseMessage)this.messages.get(i)));
      i += 1;
    }
    super.toBundle(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaMergedConvs
 * JD-Core Version:    0.7.0.1
 */