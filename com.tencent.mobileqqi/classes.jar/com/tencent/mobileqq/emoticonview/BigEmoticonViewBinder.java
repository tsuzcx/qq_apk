package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import fnx;
import fny;
import fnz;
import foa;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BigEmoticonViewBinder
  extends EmoticonPanelViewBinder
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "BigEmoticonViewBinder";
  private static final int o = 2;
  private static final int p = 4;
  private static final int r = 1;
  private static final int s = 2;
  private static final int t = 3;
  private static final int u = 4;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public EmoticonPackage a;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
  private EmoticonGridViewAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter;
  private EmoticonWording jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonWording;
  private List jdField_a_of_type_JavaUtilList = null;
  private int q = 4;
  
  public BigEmoticonViewBinder(QQAppInterface paramQQAppInterface, Context paramContext, EmoticonCallback paramEmoticonCallback, int paramInt, EmoticonPackage paramEmoticonPackage)
  {
    super(paramContext, 6, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
    a(paramEmoticonPackage);
  }
  
  private List a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
    localObject = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12)).a((String)localObject);
    if (localObject != null)
    {
      int j = ((List)localObject).size();
      int i = 0;
      while (i < j)
      {
        Emoticon localEmoticon = (Emoticon)((List)localObject).get(i);
        PicEmoticonInfo localPicEmoticonInfo = new PicEmoticonInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localPicEmoticonInfo.b = this.n;
        localPicEmoticonInfo.h = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.type;
        localPicEmoticonInfo.a = localEmoticon;
        this.jdField_a_of_type_JavaUtilList.add(localPicEmoticonInfo);
        i += 1;
      }
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  private void a(View paramView)
  {
    Object localObject1 = paramView.findViewById(2131231637);
    GridView localGridView = (GridView)paramView.findViewById(2131233302);
    localGridView.setVisibility(8);
    Object localObject4 = ((View)localObject1).findViewById(2131231612);
    Button localButton1 = (Button)((View)localObject1).findViewById(2131231615);
    Object localObject2 = ((View)localObject1).findViewById(2131231617);
    ProgressBar localProgressBar = (ProgressBar)((View)localObject1).findViewById(2131231618);
    ImageButton localImageButton = (ImageButton)((View)localObject1).findViewById(2131231619);
    View localView = ((View)localObject1).findViewById(2131231608);
    paramView = (ImageView)((View)localObject1).findViewById(2131231607);
    Object localObject3 = (TextView)((View)localObject1).findViewById(2131231613);
    Object localObject5 = (TextView)((View)localObject1).findViewById(2131231614);
    Button localButton2 = (Button)((View)localObject1).findViewById(2131231606);
    Button localButton3 = (Button)((View)localObject1).findViewById(2131231611);
    localObject5 = (Button)((View)localObject1).findViewById(2131231616);
    TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131231609);
    TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131231610);
    localButton3.setOnClickListener(this);
    ((Button)localObject5).setOnClickListener(this);
    localButton1.setOnClickListener(this);
    localImageButton.setOnClickListener(this);
    localButton3.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131563177));
    ((Button)localObject5).setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131562563));
    if (this.q == 1) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.status != 2)
      {
        ((View)localObject1).setVisibility(0);
        ((View)localObject2).setVisibility(4);
        localView.setVisibility(8);
        ((View)localObject4).setVisibility(0);
        localButton1.setVisibility(8);
        ((Button)localObject5).setVisibility(0);
        ((View)localObject2).setVisibility(8);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.name;
        if (localObject2 != null)
        {
          if (((String)localObject2).contains("暴走漫画")) {
            ((TextView)localObject3).setText("Rage Comics");
          }
        }
        else if (((View)localObject1).getBackground() != null) {
          ((View)localObject1).getBackground().setAlpha(0);
        }
      }
    }
    for (;;)
    {
      localObject1 = EmosmUtils.getCoverBitmap(2, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      if (localObject1 == null) {
        break label1051;
      }
      paramView.setImageBitmap((Bitmap)localObject1);
      return;
      if (((String)localObject2).contains("驴小毛"))
      {
        ((TextView)localObject3).setText("Mo Donkey");
        break;
      }
      if (((String)localObject2).contains("babyQ"))
      {
        ((TextView)localObject3).setText("babyQ");
        break;
      }
      if (((String)localObject2).contains("冷兔耍贱篇"))
      {
        ((TextView)localObject3).setText("Cheap Lengtoo");
        break;
      }
      if (((String)localObject2).contains("炮炮兵乐"))
      {
        ((TextView)localObject3).setText("Popois");
        break;
      }
      ((TextView)localObject3).setText("HD Emoticon");
      break;
      localGridView.setVisibility(0);
      localGridView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      int i = (int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 4.0F);
      localGridView.setPadding(i, 0, i, 0);
      localGridView.setNumColumns(-1);
      localGridView.setGravity(17);
      localGridView.setStretchMode(2);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter == null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter = new EmoticonGridViewAdapter(localGridView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter.a(this.jdField_a_of_type_JavaUtilList);
      i = a(this.q);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter.d(i);
      localGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter);
      ((View)localObject1).setBackgroundColor(-16777216);
      ((View)localObject1).getBackground().setAlpha(178);
      localButton2.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.name != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonWording == null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonWording = new EmoticonWording(this.jdField_a_of_type_AndroidContentContext);
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonWording.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.wordingId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.expiretime);
        localButton2.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.name + (String)localObject3);
        localTextView2.setText((CharSequence)localObject3);
        localTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.name);
      }
      ((View)localObject1).setVisibility(0);
      localView.setVisibility(0);
      ((View)localObject4).setVisibility(8);
      ((View)localObject2).setVisibility(8);
      continue;
      if (this.q == 3)
      {
        ((View)localObject1).setVisibility(0);
        if (((View)localObject1).getBackground() != null) {
          ((View)localObject1).getBackground().setAlpha(0);
        }
        localObject1 = EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.name;
        if (localObject4 != null)
        {
          if (!((String)localObject4).contains("暴走漫画")) {
            break label931;
          }
          ((TextView)localObject3).setText("Rage Comics");
        }
        for (;;)
        {
          float f = ((EmoticonController)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
          if (QLog.isColorLevel()) {
            QLog.d("BigEmoticonViewBinder", 2, "Ep id=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + ", progress=" + f);
          }
          if (f < 0.0F) {
            break label1021;
          }
          localView.setVisibility(8);
          localButton1.setVisibility(8);
          ((Button)localObject5).setVisibility(8);
          ((View)localObject2).setVisibility(0);
          localProgressBar.setProgress((int)(f * 100.0F));
          break;
          label931:
          if (((String)localObject4).contains("驴小毛")) {
            ((TextView)localObject3).setText("Mo Donkey");
          } else if (((String)localObject4).contains("babyQ")) {
            ((TextView)localObject3).setText("babyQ");
          } else if (((String)localObject4).contains("冷兔耍贱篇")) {
            ((TextView)localObject3).setText("Cheap Lengtoo");
          } else if (((String)localObject4).contains("炮炮兵乐")) {
            ((TextView)localObject3).setText("Popois");
          } else {
            ((TextView)localObject3).setText("HD Emoticon");
          }
        }
        label1021:
        ((View)localObject2).setVisibility(8);
        localView.setVisibility(8);
        ((Button)localObject5).setVisibility(8);
        localButton1.setVisibility(0);
      }
    }
    label1051:
    paramView.setImageResource(2130837628);
  }
  
  public static Drawable b(Context paramContext)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130837639);
    paramContext = paramContext.getResources().getDrawable(2130837640);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842913 }, paramContext);
    localStateListDrawable.addState(new int[0], localDrawable);
    return localStateListDrawable;
  }
  
  private void b(View paramView)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131231647);
    TextView localTextView2 = (TextView)paramView.findViewById(2131231648);
    Button localButton = (Button)paramView.findViewById(2131231649);
    ImageView localImageView = (ImageView)paramView.findViewById(2131231607);
    ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(2131231618);
    paramView = paramView.findViewById(2131231650);
    localTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.name);
    localTextView2.setText(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.updateTip);
    localButton.setOnClickListener(this);
    float f = EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    if (f >= 0.0F) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.status == 2)
      {
        localButton.setVisibility(8);
        paramView.setVisibility(0);
        localProgressBar.setProgress((int)(f * 100.0F));
      }
    }
    for (;;)
    {
      paramView = EmosmUtils.getCoverBitmap(2, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      if (paramView == null) {
        break;
      }
      localImageView.setImageBitmap(paramView);
      return;
      if (EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage))
      {
        localButton.setVisibility(0);
        paramView.setVisibility(8);
      }
    }
    localImageView.setImageResource(2130837628);
  }
  
  private void b(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = a();
    }
    paramInt = a(paramInt);
    paramView = (GridView)paramView;
    paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    int i = (int)(4.0F * f);
    int j = (int)(f * 82.0F);
    paramView.setPadding(i, 0, i, 0);
    paramView.setNumColumns(-1);
    paramView.setColumnWidth(j);
    paramView.setGravity(17);
    paramView.setStretchMode(2);
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter = new EmoticonGridViewAdapter(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter.d(paramInt);
    paramView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.status;
    boolean bool = EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
    if ((!this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.valid) || (i == 3))
    {
      this.q = 1;
      return;
    }
    if (bool)
    {
      this.q = 2;
      return;
    }
    if (i != 2)
    {
      this.q = 3;
      return;
    }
    this.q = 4;
  }
  
  public int a()
  {
    int j = 0;
    int k = 0;
    int i = k;
    switch (this.q)
    {
    default: 
      i = k;
    }
    int m;
    do
    {
      do
      {
        do
        {
          return i;
          if (this.jdField_a_of_type_JavaUtilList == null) {
            this.jdField_a_of_type_JavaUtilList = a();
          }
          k = this.jdField_a_of_type_JavaUtilList.size();
          i = j;
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            i = j;
            if (k > 0)
            {
              j = 0 + k / 8;
              i = j;
              if (k % 8 != 0) {
                i = j + 1;
              }
            }
          }
          return i + 1;
          if (this.jdField_a_of_type_JavaUtilList == null) {
            this.jdField_a_of_type_JavaUtilList = a();
          }
          m = this.jdField_a_of_type_JavaUtilList.size();
          i = k;
        } while (this.jdField_a_of_type_JavaUtilList == null);
        i = k;
      } while (m <= 0);
      j = 0 + m / 8;
      i = j;
    } while (m % 8 == 0);
    return j + 1;
  }
  
  public int a(int paramInt)
  {
    int i = 2005;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) {
      return -1;
    }
    switch (this.q)
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      return i;
      if (paramInt == 0)
      {
        i = 2004;
      }
      else
      {
        i = 2006;
        continue;
        i = 2006;
      }
    }
  }
  
  public Drawable a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null)
    {
      Object localObject1 = EmosmUtils.getCoverPath(3, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      Object localObject2 = EmosmUtils.getCoverPath(4, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      File localFile1 = new File((String)localObject1);
      File localFile2 = new File((String)localObject2);
      try
      {
        if ((localFile1.exists()) && (localFile2.exists()))
        {
          localObject2 = new BitmapDrawable(paramContext.getResources(), (String)localObject2);
          paramContext = new BitmapDrawable(paramContext.getResources(), (String)localObject1);
          localObject1 = new StateListDrawable();
          ((StateListDrawable)localObject1).addState(new int[] { 16842913 }, paramContext);
          ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject2);
          return localObject1;
        }
      }
      catch (OutOfMemoryError paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.w("PicEmoticonPanelInfo", 1, "getTabDrawable OOM return null");
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = null;
  }
  
  public void a(int paramInt)
  {
    Object localObject = c(0);
    if (localObject != null)
    {
      localObject = (ProgressBar)((View)localObject).findViewById(2131231618);
      if (localObject != null) {
        ((ProgressBar)localObject).post(new fnx(this, (ProgressBar)localObject, paramInt));
      }
    }
  }
  
  protected void a(View paramView, int paramInt)
  {
    if ((paramView == null) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null)) {}
    int i;
    do
    {
      do
      {
        return;
        i = a(paramInt);
      } while (paramInt > b());
      if (i == 2006)
      {
        b(paramView, paramInt);
        return;
      }
      if (i == 2005)
      {
        a(paramView);
        return;
      }
    } while (i != 2004);
    b(paramView);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
    f();
  }
  
  public int b()
  {
    return 1;
  }
  
  public void b()
  {
    View localView = c(0);
    localView.post(new fny(this, localView));
  }
  
  public void c()
  {
    Object localObject = c(0);
    if (localObject != null)
    {
      localObject = (ImageView)((View)localObject).findViewById(2131231607);
      if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0)) {
        ((ImageView)localObject).post(new fnz(this, (ImageView)localObject));
      }
    }
  }
  
  public void d()
  {
    if ((this.q == 2) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.hasReadUpdatePage))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.hasReadUpdatePage = true;
      this.jdField_a_of_type_Int = 1;
      ThreadManager.b(new foa(this));
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131231649: 
    case 2131231611: 
    case 2131231616: 
    case 2131231615: 
      do
      {
        do
        {
          do
          {
            return;
          } while (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null);
          paramView = EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramView.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, true);
          localObject3 = c(0);
          localObject1 = (Button)((View)localObject3).findViewById(2131231649);
          localObject2 = (ProgressBar)((View)localObject3).findViewById(2131231618);
          localObject3 = ((View)localObject3).findViewById(2131231650);
          ((View)localObject3).setVisibility(0);
          f = paramView.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
          if (f >= 0.0F)
          {
            ((Button)localObject1).setVisibility(8);
            ((View)localObject3).setVisibility(0);
            ((ProgressBar)localObject2).setProgress((int)(100.0F * f));
          }
          for (;;)
          {
            this.jdField_a_of_type_Int = 0;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_aio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.localVersion, "" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.latestVersion, "");
            return;
            ((Button)localObject1).setVisibility(0);
            ((View)localObject3).setVisibility(8);
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null);
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null);
      paramView = EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.isRecommendation)
      {
        ((EmosmHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_endoffer_click", 0, 0, "", "", "", "");
      }
      localObject1 = c(0);
      Object localObject2 = (ImageButton)((View)localObject1).findViewById(2131231619);
      localObject2 = (Button)((View)localObject1).findViewById(2131231615);
      Object localObject3 = (ProgressBar)((View)localObject1).findViewById(2131231618);
      localObject1 = ((View)localObject1).findViewById(2131231617);
      float f = paramView.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      ((Button)localObject2).setVisibility(8);
      ((View)localObject1).setVisibility(0);
      ((ProgressBar)localObject3).setProgress((int)(100.0F * f));
      paramView.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, true);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_pkg_download_aio", 0, 0, "", "", "", "");
      return;
    }
    EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).e(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
    paramView = c(0);
    Object localObject1 = (Button)paramView.findViewById(2131231615);
    paramView.findViewById(2131231617).setVisibility(8);
    ((Button)localObject1).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BigEmoticonViewBinder
 * JD-Core Version:    0.7.0.1
 */