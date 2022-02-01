package com.tencent.av.ui.beauty;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import aqha;
import aqnm;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.FadingHorizontalScrollView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import ior;
import java.util.ArrayList;
import java.util.Iterator;
import jfv;
import jfw;
import jjc;
import jlg;
import jll;
import wja;

public class BeautyView
  extends BeautyBaseView
{
  static final Object[][] jdField_a_of_type_Array2dOfJavaLangObject;
  private boolean YZ = true;
  final FadingHorizontalScrollView jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView;
  int ayH = 0;
  final BeautySeekView b;
  public final Button bz;
  final LinearLayout dj;
  final ArrayList<a> iW = new ArrayList(12);
  VideoAppInterface mApp;
  
  static
  {
    Object[] arrayOfObject = { "CHIN", Integer.valueOf(2131697573), Integer.valueOf(2130842774) };
    jdField_a_of_type_Array2dOfJavaLangObject = new Object[][] { { "BEAUTY_SKIN", Integer.valueOf(2131697591), Integer.valueOf(2130842784) }, { "FACE_SHAPE_4", Integer.valueOf(2131697575), Integer.valueOf(2130842775) }, { "COLOR_TONE", Integer.valueOf(2131697590), Integer.valueOf(2130842785) }, { "FACE_V", Integer.valueOf(2131697578), Integer.valueOf(2130842778) }, { "FACE_THIN", Integer.valueOf(2131697577), Integer.valueOf(2130842776) }, { "FACE_SHORTEN", Integer.valueOf(2131697576), Integer.valueOf(2130842777) }, arrayOfObject, { "ENLARGE_EYE", Integer.valueOf(2131697574), Integer.valueOf(2130842779) }, { "EYE_LIGHTEN", Integer.valueOf(2131697582), Integer.valueOf(2130842780) }, { "NOSE_THIN", Integer.valueOf(2131697587), Integer.valueOf(2130842786) }, { "MOUTH_SHAPE", Integer.valueOf(2131697584), Integer.valueOf(2130842782) }, { "TOOTH_WHITEN", Integer.valueOf(2131697598), Integer.valueOf(2130842787) } };
  }
  
  public BeautyView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BeautyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BeautyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131559944, this);
    this.b = ((BeautySeekView)findViewById(2131363380));
    this.bz = ((Button)findViewById(2131363359));
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView = ((FadingHorizontalScrollView)findViewById(2131363376));
    this.dj = ((LinearLayout)findViewById(2131363375));
    int i = (int)(ImmersiveUtils.getScreenWidth() / 5.6F);
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView.setFadingMode(1);
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView.setFadingEdgeLength(i / 2);
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView.setOverScrollMode(2);
    paramContext = (RelativeLayout.LayoutParams)this.bz.getLayoutParams();
    boolean bool;
    if (paramContext == null)
    {
      paramContext = new RelativeLayout.LayoutParams(i, -2);
      this.bz.setLayoutParams(paramContext);
      a(this.bz, 2131697572, 2130842783, 2131166207, Integer.valueOf(2131363359));
      paramContext = BaseApplicationImpl.getApplication().getRuntime();
      if (!(paramContext instanceof VideoAppInterface)) {
        break label426;
      }
      this.mApp = ((VideoAppInterface)paramContext);
      if (AVNotifyCenter.ar(this.mApp.getCurrentAccountUin()) != 0) {
        break label420;
      }
      bool = true;
      label219:
      this.YZ = bool;
      paramContext = this.mApp.a();
      label233:
      paramInt = 0;
      label235:
      if (paramInt >= jdField_a_of_type_Array2dOfJavaLangObject.length) {
        break label445;
      }
      Object localObject = new a();
      ((a)localObject).mName = ((String)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][0]);
      ((a)localObject).ayI = ((Integer)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][1]).intValue();
      ((a)localObject).mIconResId = ((Integer)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][2]).intValue();
      ((a)localObject).value = paramContext.at(((a)localObject).mName);
      ((a)localObject).ayK = paramContext.au(((a)localObject).mName);
      ((a)localObject).index = paramInt;
      this.iW.add(localObject);
      paramAttributeSet = a((a)localObject);
      localObject = new LinearLayout.LayoutParams(Math.max(i, ((a)localObject).ayJ), -2);
      this.dj.addView(paramAttributeSet, (ViewGroup.LayoutParams)localObject);
      if (this.ayH != paramInt) {
        break label437;
      }
      paramAttributeSet.setSelected(true);
    }
    for (;;)
    {
      paramInt += 1;
      break label235;
      paramContext.width = i;
      paramContext.height = -2;
      break;
      label420:
      bool = false;
      break label219;
      label426:
      paramContext = new ior();
      break label233;
      label437:
      paramAttributeSet.setSelected(false);
    }
    label445:
    avO();
    this.b.setBeautySeekActionListener(this);
  }
  
  View a(a parama)
  {
    Button localButton = new Button(getContext());
    a(localButton, parama.ayI, parama.mIconResId, 2131166206, parama);
    parama.ayJ = ((int)Math.max(jll.a(localButton), wja.dp2px(28.0F, getResources())));
    return localButton;
  }
  
  void a(Button paramButton, int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    Resources localResources = getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt2);
    jlg localjlg = jlg.a(localResources, paramInt2, paramInt3);
    localjlg.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    paramButton.setCompoundDrawables(null, localjlg, null, null);
    paramButton.setTextColor(localResources.getColorStateList(paramInt3));
    paramButton.setText(paramInt1);
    paramButton.setBackgroundDrawable(null);
    paramButton.setOnClickListener(this);
    paramButton.setTag(2131372726, paramObject);
    paramButton.setTextSize(aqnm.pxTosp(wja.dp2px(12.0F, getResources())));
    paramButton.setCompoundDrawablePadding(wja.dp2px(8.0F, getResources()));
  }
  
  void avO()
  {
    Resources localResources = getResources();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.ayH >= 0)
    {
      localObject1 = localObject2;
      if (this.ayH < this.iW.size()) {
        localObject1 = (a)this.iW.get(this.ayH);
      }
    }
    if (localObject1 != null) {
      this.b.a(localResources.getString(((a)localObject1).ayI), ((a)localObject1).mName, ((a)localObject1).value, ((a)localObject1).ayK);
    }
  }
  
  public void j(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {}
    label146:
    for (;;)
    {
      return;
      Iterator localIterator = this.iW.iterator();
      a locala;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        locala = (a)localIterator.next();
      } while (!paramString.equals(locala.mName));
      for (;;)
      {
        if (locala == null) {
          break label146;
        }
        switch (paramInt1)
        {
        case 1: 
        default: 
          return;
        case 2: 
          locala.value = paramInt2;
          if (this.mApp == null) {
            break;
          }
          this.mApp.c(paramString, paramInt2, false);
          return;
        case 3: 
          locala.value = paramInt2;
          if (this.mApp != null) {
            this.mApp.c(paramString, paramInt2, true);
          }
          jjc.au("0X800A569", locala.index + 1);
          return;
          locala = null;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.bz) {
      if (this.YZ)
      {
        this.YZ = false;
        if (this.mApp != null) {
          AVNotifyCenter.ah(this.mApp.getCurrentAccountUin(), 1);
        }
        aqha.a((Activity)getContext(), getResources().getString(2131697588), 2131721058, 2131721079, new jfv(this), new jfw(this)).show();
      }
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.mApp != null)
        {
          this.mApp.amS();
          localObject = this.iW.iterator();
          while (((Iterator)localObject).hasNext())
          {
            a locala = (a)((Iterator)localObject).next();
            locala.value = this.mApp.ak(locala.mName);
          }
        }
        avO();
      }
      localObject = paramView.getTag(2131372726);
    } while (!(localObject instanceof a));
    Object localObject = (a)localObject;
    if (((a)localObject).index == this.ayH) {}
    for (;;)
    {
      jjc.au("0X800A568", ((a)localObject).index + 1);
      break;
      if ((this.ayH >= 0) && (this.ayH < this.dj.getChildCount())) {
        this.dj.getChildAt(this.ayH).setSelected(false);
      }
      paramView.setSelected(true);
      this.ayH = ((a)localObject).index;
      avO();
    }
  }
  
  public void refreshUI()
  {
    this.ayH = 0;
    Object localObject;
    if (this.mApp != null)
    {
      localObject = this.mApp.a();
      i = 0;
      while (i < this.iW.size())
      {
        a locala = (a)this.iW.get(i);
        locala.value = ((ior)localObject).at(locala.mName);
        i += 1;
      }
    }
    int j = this.dj.getChildCount();
    int i = 0;
    if (i < j)
    {
      localObject = this.dj.getChildAt(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (i == this.ayH) {
          ((View)localObject).setSelected(true);
        } else {
          ((View)localObject).setSelected(false);
        }
      }
    }
    avO();
  }
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    super.setAppInterface(paramVideoAppInterface);
    if (this.mApp != null)
    {
      if (AVNotifyCenter.ar(this.mApp.getCurrentAccountUin()) == 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.YZ = bool;
        paramVideoAppInterface = this.mApp.a();
        Iterator localIterator = this.iW.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala != null) {
            locala.value = paramVideoAppInterface.at(locala.mName);
          }
        }
      }
      avO();
    }
  }
  
  static class a
  {
    public int ayI;
    public int ayJ;
    public int ayK;
    public int index;
    public int mIconResId;
    public String mName;
    public int value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautyView
 * JD-Core Version:    0.7.0.1
 */