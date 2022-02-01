package com.tencent.tim.todo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import augw;
import augx;
import aunt;
import aunz;
import com.tencent.tim.fragment.BaseFragmentActivity;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class TodoListActivity
  extends BaseFragmentActivity
  implements augx, aunt
{
  private aunz a;
  private boolean dji;
  private boolean djj;
  private ViewGroup rootView;
  private boolean started;
  
  public boolean Pp()
  {
    return this.started;
  }
  
  public List<augw> cH()
  {
    return new ArrayList();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.rootView.requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
        this.rootView.requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      paramIntent = paramIntent.getExtras();
    } while ((paramIntent == null) || (paramIntent.getInt("BUSI_TYPE") != 1043) || (this.a == null));
    this.a.dY(paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.a(getWindow(), true);
    }
    this.djj = getIntent().getBooleanExtra("from_me_tab", false);
    if (!this.djj) {
      overridePendingTransition(0, 0);
    }
    setContentView(2131563216);
    this.rootView = ((ViewGroup)findViewById(2131377551));
    this.a = new aunz(this, this.app, this, this);
    this.a.W(this.rootView);
    if (this.a.a() != null) {
      this.xt.add(this.a.a());
    }
    this.a.evM();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.a.onDestroy();
    super.doOnDestroy();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.started = true;
    this.a.onStart();
    if ((!TextUtils.isEmpty(getIntent().getStringExtra("highlight_todo_id"))) && (!this.dji))
    {
      this.a.Zt(getIntent().getStringExtra("highlight_todo_id"));
      this.dji = true;
    }
  }
  
  public void doOnStop()
  {
    this.a.onStop();
    this.started = false;
    super.doOnStop();
  }
  
  public void evD()
  {
    finish();
  }
  
  public void finish()
  {
    super.finish();
    if (!this.djj) {
      overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.todo.TodoListActivity
 * JD-Core Version:    0.7.0.1
 */