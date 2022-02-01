package dov.com.qq.im.ae.camera.ui.watermark;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import axaw;
import axaw.a;
import axbe;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.string.StringUtils;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.model.WMLogic;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.HashMap;
import java.util.List;

public class WatermarkEditView
  extends RelativeLayout
  implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener
{
  private axaw jdField_a_of_type_Axaw;
  private a jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView$a;
  private WatermarkListView jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView;
  private int mActionBarHeight;
  private Activity mActivity;
  private DatePicker mDatePicker;
  
  public WatermarkEditView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WatermarkEditView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WatermarkEditView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void aLz()
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  public void eIx()
  {
    this.jdField_a_of_type_Axaw = new axaw(this.mActivity, LogicDataManager.getInstance().getEditableWMElement());
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.setAdapter(this.jdField_a_of_type_Axaw, LogicDataManager.getInstance().getEditableWMElement());
    this.mDatePicker.setVisibility(8);
    this.mDatePicker.init(this.mDatePicker.getYear(), this.mDatePicker.getMonth(), this.mDatePicker.getDayOfMonth(), this.jdField_a_of_type_Axaw);
    this.jdField_a_of_type_Axaw.a(new axbe(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.postDelayed(new WatermarkEditView.2(this), 100L);
    setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aLz();
      postDelayed(new WatermarkEditView.3(this), 200L);
      int i = 0;
      if (i < this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.QY())
      {
        Object localObject = (axaw.a)this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.a(i);
        if (localObject == null) {}
        label373:
        for (;;)
        {
          i += 1;
          break;
          if (!CollectionUtils.indexOutOfBounds(LogicDataManager.getInstance().getEditableWMElement(), i))
          {
            WMElement localWMElement = (WMElement)LogicDataManager.getInstance().getEditableWMElement().get(i);
            if ((localWMElement.logic != null) && (localWMElement.logic.type != null) && ((localWMElement.logic.type.equals("since")) || (localWMElement.logic.type.equals("countdown"))))
            {
              if ((((axaw.a)localObject).editText.getTag() != null) && ((((axaw.a)localObject).editText.getTag() instanceof String)))
              {
                localObject = (String)((axaw.a)localObject).editText.getTag();
                localWMElement.userValue = ((String)localObject);
                LogicDataManager.getInstance().recordDate(localWMElement.logic.type, localWMElement.sid, (String)localObject);
              }
            }
            else if (localWMElement.ischeckin)
            {
              if (((axaw.a)localObject).dtU)
              {
                ((axaw.a)localObject).dtU = false;
                localWMElement.resetDays();
              }
            }
            else
            {
              localObject = StringUtils.removeUTF8Emoji(((axaw.a)localObject).editText.getText().toString().trim());
              if (!((String)localObject).equals(((axaw)this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.getAdapter()).gQ(i))) {
                localWMElement.userValue = ((String)localObject);
              }
              if (!((String)localObject).equals("")) {
                LogicDataManager.getInstance().mFollowData.put(localWMElement.id, localObject);
              }
              for (;;)
              {
                if (localWMElement.persistence != 1) {
                  break label373;
                }
                localWMElement.saveTitle((String)localObject);
                break;
                LogicDataManager.getInstance().mFollowData.put(localWMElement.id, localWMElement.getDefault());
              }
            }
          }
        }
      }
      if (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView$a != null)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView$a.eIy();
        continue;
        aLz();
        postDelayed(new WatermarkEditView.4(this), 200L);
      }
    }
  }
  
  public void onGlobalLayout()
  {
    if ((this.mDatePicker != null) && (this.mDatePicker.getVisibility() != 0) && (this.mActivity != null))
    {
      Rect localRect = new Rect();
      this.mActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void p(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView = ((WatermarkListView)findViewById(2131366258));
    this.mDatePicker = ((DatePicker)findViewById(2131365609));
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    findViewById(2131379467).setOnClickListener(this);
    findViewById(2131379468).setOnClickListener(this);
  }
  
  public void setActionBarHeight(int paramInt)
  {
    this.mActionBarHeight = paramInt;
  }
  
  public void setOnRenderTextListener(a parama)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void eIy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditView
 * JD-Core Version:    0.7.0.1
 */