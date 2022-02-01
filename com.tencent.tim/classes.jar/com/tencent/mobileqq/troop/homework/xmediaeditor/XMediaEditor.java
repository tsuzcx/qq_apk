package com.tencent.mobileqq.troop.homework.xmediaeditor;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import apkj;
import apkk;
import apkn;
import apko;
import apkq;
import apkr;
import apks;
import apkt;
import apku;
import apkw;
import apky;
import aplb.a;
import apld;
import aple;
import aplj;
import aplj.a;
import aplq;
import aurd;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;

public class XMediaEditor
  extends RecyclerView
{
  public apkk a;
  private apkt jdField_a_of_type_Apkt;
  aplb.a jdField_a_of_type_Aplb$a = new apkj(this);
  private apld jdField_a_of_type_Apld;
  private a jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$a;
  private b jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$b;
  private c jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$c;
  private Bundle bp = new Bundle();
  private boolean cRb = true;
  private boolean cRc = true;
  private boolean cRd;
  private String cpM;
  private int dUO;
  private int dUP;
  private int mContentLength;
  private View mHeaderView;
  private int mMaxHeight = 2147483647;
  
  public XMediaEditor(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public XMediaEditor(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public XMediaEditor(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new LinearLayoutManager(paramContext);
    addItemDecoration(new d(26));
    setLayoutManager(paramAttributeSet);
    paramAttributeSet = new SparseArray();
    this.jdField_a_of_type_Apld = new apld(this, paramContext);
    this.jdField_a_of_type_Apld.a(this.jdField_a_of_type_Aplb$a);
    paramAttributeSet.put(-1, this.jdField_a_of_type_Apld);
    paramAttributeSet.put(0, new aplj(this, paramContext).a(this.jdField_a_of_type_Aplb$a));
    paramAttributeSet.put(3, new apky(this, paramContext).a(this.jdField_a_of_type_Aplb$a));
    paramAttributeSet.put(1, new aple(this).a(this.jdField_a_of_type_Aplb$a));
    paramAttributeSet.put(2, new aplq(this).a(this.jdField_a_of_type_Aplb$a));
    paramAttributeSet.put(4, new HWReciteItem(this, paramContext).a(this.jdField_a_of_type_Aplb$a));
    paramAttributeSet.put(7, new apkw(this, paramContext).a(this.jdField_a_of_type_Aplb$a));
    this.jdField_a_of_type_Apkk = new apkk(paramAttributeSet);
    setAdapter(this.jdField_a_of_type_Apkk);
    setDefaultContent();
  }
  
  private <T extends View> T b(Class<T> paramClass, View paramView)
  {
    if (paramView == null) {}
    int i;
    do
    {
      do
      {
        return null;
        if (paramClass.isInstance(paramView)) {
          return (View)paramClass.cast(paramView);
        }
      } while (!(paramView instanceof ViewGroup));
      paramView = (ViewGroup)paramView;
      i = paramView.getChildCount();
    } while (i <= 0);
    return b(paramClass, paramView.getChildAt(i - 1));
  }
  
  public int Ls()
  {
    return this.dUP;
  }
  
  public void a(apkn paramapkn)
  {
    if (paramapkn == null)
    {
      Toast.makeText(getContext(), "插入的EditItemInfoBase为空", 0).show();
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Apkk.getItemCount() == 0)
    {
      if ((paramapkn instanceof apkt))
      {
        this.jdField_a_of_type_Apkk.b(paramapkn);
        this.jdField_a_of_type_Apkk.notifyDataSetChanged();
        this.jdField_a_of_type_Apkt = ((apkt)paramapkn);
        this.jdField_a_of_type_Apkt.mPosition = 0;
        this.jdField_a_of_type_Apkt.cRf = true;
        return;
      }
      localObject1 = new apkt("");
      localObject2 = new apkt("");
      this.jdField_a_of_type_Apkk.b((apkn)localObject1);
      this.jdField_a_of_type_Apkk.b(paramapkn);
      this.jdField_a_of_type_Apkk.b((apkn)localObject2);
      this.jdField_a_of_type_Apkt = ((apkt)localObject2);
      this.jdField_a_of_type_Apkt.cRf = true;
      this.jdField_a_of_type_Apkt.mPosition = 2;
      this.jdField_a_of_type_Apkk.notifyDataSetChanged();
      this.jdField_a_of_type_Aplb$a.c(null, false);
      scrollToPosition(this.jdField_a_of_type_Apkt.mPosition);
      return;
    }
    int j;
    int i;
    if (this.jdField_a_of_type_Apkt == null)
    {
      localObject1 = this.jdField_a_of_type_Apkk.a(this.jdField_a_of_type_Apkk.getItemCount() - 1);
      if ((localObject1 instanceof apkt))
      {
        this.jdField_a_of_type_Apkt = ((apkt)localObject1);
        this.jdField_a_of_type_Apkt.cRf = true;
      }
    }
    else
    {
      j = this.jdField_a_of_type_Apkt.mPosition;
      if (this.jdField_a_of_type_Apkt.dUT < 0) {
        this.jdField_a_of_type_Apkt.dUT = 0;
      }
      i = this.jdField_a_of_type_Apkt.dUT;
      localObject1 = (aplj.a)findViewHolderForAdapterPosition(j);
      if (localObject1 == null) {
        break label655;
      }
      i = ((aplj.a)localObject1).mEditText.getSelectionStart();
    }
    label655:
    for (;;)
    {
      if (i == 0) {
        if (this.jdField_a_of_type_Apkt.mText.length() == 0)
        {
          localObject2 = "";
          localObject1 = "";
        }
      }
      for (;;)
      {
        if (!(paramapkn instanceof apkt)) {
          break label511;
        }
        paramapkn = (apkt)paramapkn;
        this.jdField_a_of_type_Apkt.setText((String)localObject2 + paramapkn.mText + (String)localObject1);
        localObject1 = this.jdField_a_of_type_Apkt;
        ((apkt)localObject1).dUT += paramapkn.mText.length();
        scrollToPosition(this.jdField_a_of_type_Apkt.mPosition);
        this.jdField_a_of_type_Aplb$a.c(null, false);
        return;
        localObject1 = new apkt("");
        this.jdField_a_of_type_Apkt = ((apkt)localObject1);
        this.jdField_a_of_type_Apkt.mPosition = this.jdField_a_of_type_Apkk.getItemCount();
        this.jdField_a_of_type_Apkk.b((apkn)localObject1);
        break;
        localObject1 = this.jdField_a_of_type_Apkt.mText;
        localObject2 = "";
        continue;
        localObject2 = this.jdField_a_of_type_Apkt.mText.substring(0, i);
        if (this.jdField_a_of_type_Apkt.mText.length() == i) {
          localObject1 = "";
        } else {
          localObject1 = this.jdField_a_of_type_Apkt.mText.substring(i);
        }
      }
      label511:
      apkn localapkn = this.jdField_a_of_type_Apkk.a(j);
      if ((localapkn instanceof apkt)) {
        ((apkt)localapkn).setText((String)localObject2);
      }
      for (;;)
      {
        localObject1 = new apkt((String)localObject1);
        this.jdField_a_of_type_Apkt.cRf = false;
        ((apkt)localObject1).cRf = true;
        ((apkt)localObject1).dUT = 0;
        this.jdField_a_of_type_Apkt = ((apkt)localObject1);
        this.jdField_a_of_type_Apkk.a(j + 1, (apkn)localObject1);
        this.jdField_a_of_type_Apkk.a(j + 1, paramapkn);
        this.jdField_a_of_type_Apkt.mPosition = (j + 2);
        this.jdField_a_of_type_Apkk.notifyDataSetChanged();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("XMediaEditor", 2, "insert item 类型不对 insertPosition" + j);
        }
      }
    }
  }
  
  public boolean aBh()
  {
    return this.jdField_a_of_type_Apkk.aBh();
  }
  
  public void aLz()
  {
    this.jdField_a_of_type_Apkt.cRf = false;
    aplj.a locala = (aplj.a)findViewHolderForAdapterPosition(this.jdField_a_of_type_Apkt.mPosition);
    if (locala != null)
    {
      locala.mEditText.setFocusable(false);
      locala.mEditText.setFocusableInTouchMode(false);
      ThreadManager.getUIHandler().post(new XMediaEditor.2(this, locala));
    }
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return (this.cRb) && (super.canScrollVertically(paramInt));
  }
  
  public void clearData()
  {
    setDefaultContent();
  }
  
  public void dQ(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Apkk.dR(paramInt, paramString);
    this.jdField_a_of_type_Aplb$a.c(null, false);
  }
  
  public ArrayList<apku> dS()
  {
    return this.jdField_a_of_type_Apkk.dS();
  }
  
  public ArrayList<apkr> dT()
  {
    return this.jdField_a_of_type_Apkk.dT();
  }
  
  public void df(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Apkk.WP(0);
      this.jdField_a_of_type_Apkk.notifyDataSetChanged();
      this.jdField_a_of_type_Aplb$a.c(null, false);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Apkk.a(paramInt - 1);
    if (paramInt + 1 < this.jdField_a_of_type_Apkk.getItemCount()) {}
    for (Object localObject1 = this.jdField_a_of_type_Apkk.a(paramInt + 1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if ((localObject2 instanceof apkt))
        {
          if (this.jdField_a_of_type_Apkt != null) {
            this.jdField_a_of_type_Apkt.cRf = false;
          }
          this.jdField_a_of_type_Apkt = ((apkt)localObject2);
          this.jdField_a_of_type_Apkt.cRf = true;
        }
        this.jdField_a_of_type_Apkk.WP(paramInt);
        this.jdField_a_of_type_Apkk.notifyDataSetChanged();
        this.jdField_a_of_type_Aplb$a.c(null, false);
        return;
      }
      if ((!(localObject1 instanceof apkt)) || (!(localObject2 instanceof apkt)))
      {
        this.jdField_a_of_type_Apkk.WP(paramInt);
        this.jdField_a_of_type_Apkk.notifyDataSetChanged();
        this.jdField_a_of_type_Aplb$a.c(null, false);
        return;
      }
      localObject1 = (apkt)localObject1;
      localObject2 = (apkt)localObject2;
      ((apkt)localObject2).dUT = ((apkt)localObject2).mText.length();
      aplj.a locala = (aplj.a)findViewHolderForAdapterPosition(((apkt)localObject2).mPosition);
      if (locala != null) {
        locala.mEditText.setSelection(((apkt)localObject2).dUT);
      }
      if (TextUtils.isEmpty(((apkt)localObject1).mText))
      {
        if (this.jdField_a_of_type_Apkt != null) {
          this.jdField_a_of_type_Apkt.cRf = false;
        }
        this.jdField_a_of_type_Apkt = ((apkt)localObject2);
        this.jdField_a_of_type_Apkt.cRf = true;
        this.jdField_a_of_type_Apkk.WP(paramInt + 1);
        this.jdField_a_of_type_Apkk.WP(paramInt);
        this.jdField_a_of_type_Apkk.notifyDataSetChanged();
        this.jdField_a_of_type_Aplb$a.c(null, false);
        if (paramInt - 1 < 0) {
          break label369;
        }
        paramInt -= 1;
      }
      for (;;)
      {
        scrollToPosition(paramInt);
        return;
        if (TextUtils.isEmpty(((apkt)localObject2).mText))
        {
          ((apkt)localObject2).mText = ((apkt)localObject1).mText;
          break;
        }
        ((apkt)localObject2).mText += ((apkt)localObject1).mText;
        break;
        label369:
        paramInt = 0;
      }
    }
  }
  
  public void eaw()
  {
    this.mHeaderView = null;
    this.jdField_a_of_type_Apld.setHeaderView(null);
    if (this.jdField_a_of_type_Apkk.aBh())
    {
      this.jdField_a_of_type_Apkk.WP(0);
      this.jdField_a_of_type_Apkk.notifyDataSetChanged();
    }
  }
  
  public void fb(ArrayList<apku> paramArrayList)
  {
    this.jdField_a_of_type_Apkk.fb(paramArrayList);
  }
  
  public int getContentLength()
  {
    return this.mContentLength;
  }
  
  public String getData()
  {
    return this.jdField_a_of_type_Apkk.getData();
  }
  
  public String getHint()
  {
    return this.cpM;
  }
  
  public int getShowType()
  {
    return this.jdField_a_of_type_Apkk.getShowType();
  }
  
  public int jI(int paramInt)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_Apkk.getItemCount(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_Apkk.a(i).getType() == paramInt) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public void mP(List<apkn> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      a((apkn)paramList.get(i));
      i += 1;
    }
  }
  
  public String oG(String paramString)
  {
    return this.bp.getString(paramString);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Apkk.release();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.cRc) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mMaxHeight != 2147483647) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getShowType() == 0) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      EditText localEditText = (EditText)b(EditText.class, this);
      if (localEditText != null)
      {
        int[] arrayOfInt = new int[2];
        localEditText.getLocationOnScreen(arrayOfInt);
        float f = paramMotionEvent.getRawY();
        if (arrayOfInt[1] <= f)
        {
          if (QLog.isColorLevel()) {
            QLog.d("XMediaEditor", 2, "Oops! found et");
          }
          if (!localEditText.isFocused())
          {
            localEditText.setFocusable(true);
            localEditText.setFocusableInTouchMode(true);
            localEditText.requestFocus();
          }
          aurd.aO(localEditText);
        }
      }
    }
  }
  
  public void setChildClickable(boolean paramBoolean)
  {
    this.cRc = paramBoolean;
  }
  
  public void setCommitStateChangeListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$a = parama;
  }
  
  public void setContentLengthChangeListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$b = paramb;
  }
  
  public void setData(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Apkk.w(new JSONArray(paramString));
      this.jdField_a_of_type_Aplb$a.c(null, false);
      int i = this.jdField_a_of_type_Apkk.Lt();
      this.jdField_a_of_type_Aplb$a.jR(this.mContentLength, i);
      this.mContentLength = i;
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setDataByEdit(JSONArray paramJSONArray)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramJSONArray.length())
        {
          apkn localapkn = apko.a(paramJSONArray.getJSONObject(i));
          if (localapkn == null) {
            break label201;
          }
          if ((localapkn instanceof apku))
          {
            ((apku)localapkn).mUploadStatus = 3;
            if ((localapkn instanceof apks)) {
              ((apks)localapkn).mProgress = 100;
            }
          }
          if ((localapkn instanceof apkt))
          {
            this.jdField_a_of_type_Apkt.setText(((apkt)localapkn).mText);
            this.jdField_a_of_type_Apkt.dUT = ((apkt)localapkn).mText.length();
            this.jdField_a_of_type_Apkt.cRf = false;
            this.jdField_a_of_type_Apkk.notifyDataSetChanged();
          }
          else
          {
            a(localapkn);
          }
        }
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return;
      }
      int j = this.jdField_a_of_type_Apkk.Lt();
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          paramJSONArray = this.jdField_a_of_type_Apkk.a(i);
          if ((paramJSONArray instanceof apkt))
          {
            this.jdField_a_of_type_Apkt = ((apkt)paramJSONArray);
            this.jdField_a_of_type_Apkt.cRf = true;
          }
        }
        else
        {
          this.jdField_a_of_type_Apkk.notifyDataSetChanged();
          scrollToPosition(0);
          return;
        }
        i += 1;
      }
      label201:
      i += 1;
    }
  }
  
  public void setDefaultContent()
  {
    setData("[" + new apkt("").toString() + "]");
    this.jdField_a_of_type_Apkt = ((apkt)this.jdField_a_of_type_Apkk.a(0));
  }
  
  public void setExtraValue(String paramString1, String paramString2)
  {
    this.bp.putString(paramString1, paramString2);
  }
  
  public void setFocusChangeListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$c = paramc;
  }
  
  public void setHeaderView(View paramView)
  {
    if (paramView == null)
    {
      eaw();
      return;
    }
    this.mHeaderView = paramView;
    this.jdField_a_of_type_Apld.setHeaderView(this.mHeaderView);
    if (this.jdField_a_of_type_Apkk.aBh())
    {
      this.jdField_a_of_type_Apkk.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Apkk.a(0, new apkq());
    this.jdField_a_of_type_Apkk.notifyDataSetChanged();
  }
  
  public void setHint(String paramString)
  {
    this.cpM = paramString;
  }
  
  public void setLeftRightPadding(int paramInt)
  {
    this.dUP = paramInt;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.mMaxHeight = paramInt;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.cRb = paramBoolean;
  }
  
  public void setShowType(int paramInt)
  {
    this.jdField_a_of_type_Apkk.setShowType(paramInt);
  }
  
  public void setSizeLimit(int paramInt)
  {
    this.dUO = paramInt;
  }
  
  public void showKeyboard()
  {
    this.jdField_a_of_type_Apkt.cRf = true;
    aplj.a locala = (aplj.a)findViewHolderForAdapterPosition(this.jdField_a_of_type_Apkt.mPosition);
    if (locala != null)
    {
      locala.mEditText.setFocusable(true);
      locala.mEditText.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new XMediaEditor.1(this, locala));
    }
  }
  
  public ArrayList<apkn> w(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Apkk.getItemCount())
    {
      if (this.jdField_a_of_type_Apkk.a(i).getType() == paramInt) {
        localArrayList.add(this.jdField_a_of_type_Apkk.a(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public int wC()
  {
    return this.dUO;
  }
  
  public static abstract interface a
  {
    public abstract void RP(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void jS(int paramInt1, int paramInt2);
  }
  
  public static abstract interface c
  {
    public abstract void onFocusChanged(View paramView, boolean paramBoolean);
  }
  
  public static class d
    extends RecyclerView.ItemDecoration
  {
    private int space;
    
    public d(int paramInt)
    {
      this.space = paramInt;
    }
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      if (paramRecyclerView.getChildAdapterPosition(paramView) != 0) {
        paramRect.top = this.space;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor
 * JD-Core Version:    0.7.0.1
 */