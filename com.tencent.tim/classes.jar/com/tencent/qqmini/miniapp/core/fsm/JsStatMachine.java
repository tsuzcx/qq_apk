package com.tencent.qqmini.miniapp.core.fsm;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ValueCallback;

public abstract class JsStatMachine
  extends StateMachine<Integer, Integer>
{
  public static final Integer EVENT_JS_EVALUATE_FAIL = Integer.valueOf(2);
  public static final Integer EVENT_JS_EVALUATE_SUCC = Integer.valueOf(1);
  protected JsStateListener mJsStateListener;
  protected Handler mMainHandler = new Handler(Looper.getMainLooper());
  
  public abstract void evaluateJs(String paramString1, ValueCallback paramValueCallback, String paramString2);
  
  public void sendEvent(Integer paramInteger)
  {
    Object localObject = getCurrState();
    if ((localObject instanceof JsState))
    {
      localObject = (JsState)localObject;
      if ((((JsState)localObject).nextState != null) && (EVENT_JS_EVALUATE_SUCC == paramInteger)) {
        setCurrState(((JsState)localObject).nextState);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        super.sendEvent(paramInteger);
      }
      return;
    }
  }
  
  public void setJsStateListener(JsStateListener paramJsStateListener)
  {
    this.mJsStateListener = paramJsStateListener;
  }
  
  public class JsState
    extends StateMachine.State
  {
    private String jsContent;
    private String jsPath;
    private StateMachine.State nextState;
    
    public JsState(int paramInt)
    {
      super(Integer.valueOf(paramInt));
    }
    
    public String getJsContent()
    {
      return this.jsContent;
    }
    
    public String getJsPath()
    {
      return this.jsPath;
    }
    
    public JsState nextState(StateMachine.State paramState)
    {
      this.nextState = paramState;
      return this;
    }
    
    public void onStart()
    {
      super.onStart();
      if (TextUtils.isEmpty(this.jsContent))
      {
        JsStatMachine.this.sendEvent(JsStatMachine.EVENT_JS_EVALUATE_SUCC);
        return;
      }
      if (JsStatMachine.this.mJsStateListener != null) {
        JsStatMachine.this.mJsStateListener.onJsStateStart(this);
      }
      JsStatMachine.this.evaluateJs(this.jsContent, new JsStatMachine.JsState.1(this), this.jsPath);
    }
    
    public void setJsContent(String paramString)
    {
      setJsContent(paramString, null);
    }
    
    public void setJsContent(String paramString1, String paramString2)
    {
      this.jsContent = paramString1;
      this.jsPath = paramString2;
    }
  }
  
  public static abstract interface JsStateListener
  {
    public abstract void onJsStateEnd(JsStatMachine.JsState paramJsState);
    
    public abstract void onJsStateStart(JsStatMachine.JsState paramJsState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.fsm.JsStatMachine
 * JD-Core Version:    0.7.0.1
 */