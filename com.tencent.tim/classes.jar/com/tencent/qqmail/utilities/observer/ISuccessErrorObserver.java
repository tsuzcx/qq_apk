package com.tencent.qqmail.utilities.observer;

import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.HashMap;
import java.util.Observable;

public abstract class ISuccessErrorObserver
  implements IGroupObserver
{
  public static final int ERROR_SUB_OBSERVER = 1;
  public static final int SUCCESS_SUB_OBSERVER = 0;
  
  public abstract void onError(HashMap<String, Object> paramHashMap);
  
  public abstract void onSuccess(HashMap<String, Object> paramHashMap);
  
  public final void update(Observable paramObservable, Object paramObject)
  {
    ValidateHelper.notNull(paramObject);
    paramObservable = (HashMap)paramObject;
    paramObject = (Integer)paramObservable.get("GROUP_TYPE");
    ValidateHelper.notNull(paramObject);
    if (paramObject.intValue() == 0)
    {
      onSuccess(paramObservable);
      return;
    }
    if (paramObject.intValue() == 1)
    {
      onError(paramObservable);
      return;
    }
    throw new UnsupportedOperationException("" + paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.observer.ISuccessErrorObserver
 * JD-Core Version:    0.7.0.1
 */