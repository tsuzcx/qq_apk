package com.tencent.qqmail.utilities.observer;

import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.HashMap;
import java.util.Observable;

public abstract class ICallbackObserver
  implements IGroupObserver
{
  public static final int BEFORE_SEND_SUB_OBSERVER = 0;
  public static final int COMPLETE_SUB_OBSERVER = 5;
  public static final int ERROR_SUB_OBSERVER = 4;
  public static final int RECEIVE_DATA_SUB_OBSERVER = 2;
  public static final int SEND_DATA_SUB_OBSERVER = 1;
  public static final int SUCCESS_SUB_OBSERVER = 3;
  
  public abstract void onBeforeSend(HashMap<String, Object> paramHashMap);
  
  public abstract void onComplete(HashMap<String, Object> paramHashMap);
  
  public abstract void onError(HashMap<String, Object> paramHashMap);
  
  public abstract void onReceiveData(HashMap<String, Object> paramHashMap);
  
  public abstract void onSendData(HashMap<String, Object> paramHashMap);
  
  public abstract void onSuccess(HashMap<String, Object> paramHashMap);
  
  public final void update(Observable paramObservable, Object paramObject)
  {
    ValidateHelper.notNull(paramObject);
    paramObservable = (HashMap)paramObject;
    paramObject = (Integer)paramObservable.get("GROUP_TYPE");
    ValidateHelper.notNull(paramObject);
    switch (paramObject.intValue())
    {
    default: 
      throw new UnsupportedOperationException();
    case 0: 
      onBeforeSend(paramObservable);
      return;
    case 1: 
      onSendData(paramObservable);
      return;
    case 2: 
      onReceiveData(paramObservable);
      return;
    case 3: 
      onSuccess(paramObservable);
      return;
    case 4: 
      onError(paramObservable);
      return;
    }
    onComplete(paramObservable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.observer.ICallbackObserver
 * JD-Core Version:    0.7.0.1
 */