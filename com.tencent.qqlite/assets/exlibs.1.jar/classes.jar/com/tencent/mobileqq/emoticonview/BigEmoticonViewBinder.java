package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import ddz;
import dea;
import deb;
import dec;
import dev;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class BigEmoticonViewBinder
  extends EmoticonPanelViewBinder
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "BigEmoticonViewBinder";
  private static final String b = "log_greverye";
  private static final int o = 2;
  private static final int p = 4;
  private static final int r = 1;
  private static final int s = 2;
  private static final int t = 3;
  private static final int u = 4;
  public QQAppInterface a;
  public EmoticonPackage a;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
  private EmoticonLinearLayout.EmoticonAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter;
  private List jdField_a_of_type_JavaUtilList = null;
  private JSONArray jdField_a_of_type_OrgJsonJSONArray;
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
    localObject = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a((String)localObject);
    if (localObject != null)
    {
      int j = ((List)localObject).size();
      int i = 0;
      while (i < j)
      {
        Emoticon localEmoticon = (Emoticon)((List)localObject).get(i);
        PicEmoticonInfo localPicEmoticonInfo = new PicEmoticonInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localPicEmoticonInfo.c = this.n;
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
    Object localObject1 = paramView.findViewById(2131297073);
    EmoticonLinearLayout localEmoticonLinearLayout = (EmoticonLinearLayout)paramView.findViewById(2131298653);
    localEmoticonLinearLayout.setPanelViewType(2006);
    localEmoticonLinearLayout.setVisibility(8);
    View localView3 = ((View)localObject1).findViewById(2131297057);
    Object localObject2 = (Button)((View)localObject1).findViewById(2131297060);
    View localView1 = ((View)localObject1).findViewById(2131297062);
    ProgressBar localProgressBar = (ProgressBar)((View)localObject1).findViewById(2131297063);
    ImageButton localImageButton = (ImageButton)((View)localObject1).findViewById(2131297064);
    View localView2 = ((View)localObject1).findViewById(2131297053);
    paramView = (ImageView)((View)localObject1).findViewById(2131297052);
    TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131297058);
    TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131297059);
    Button localButton1 = (Button)((View)localObject1).findViewById(2131297051);
    Button localButton3 = (Button)((View)localObject1).findViewById(2131297056);
    Button localButton2 = (Button)((View)localObject1).findViewById(2131297061);
    TextView localTextView3 = (TextView)((View)localObject1).findViewById(2131297054);
    TextView localTextView4 = (TextView)((View)localObject1).findViewById(2131297055);
    localButton3.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    ((Button)localObject2).setOnClickListener(this);
    localImageButton.setOnClickListener(this);
    localButton3.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131364048));
    localButton2.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131363543));
    if (QLog.isColorLevel()) {
      QLog.d("log_greverye", 2, "func updateDownloadView, pkgStatus:" + this.q);
    }
    if (this.q == 1) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.status != 2)
      {
        ((View)localObject1).setVisibility(0);
        localView1.setVisibility(4);
        localView2.setVisibility(8);
        localView3.setVisibility(0);
        ((Button)localObject2).setVisibility(8);
        localButton2.setVisibility(0);
        localView1.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.name != null)
        {
          localTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.name);
          if (this.jdField_a_of_type_OrgJsonJSONArray == null) {
            this.jdField_a_of_type_OrgJsonJSONArray = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          localTextView2.setText(ClubContentJsonTask.a(this.jdField_a_of_type_OrgJsonJSONArray, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.wordingId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.expiretime));
        }
        if (((View)localObject1).getBackground() != null) {
          ((View)localObject1).getBackground().setAlpha(0);
        }
      }
    }
    for (;;)
    {
      localObject1 = EmosmUtils.getCoverBitmap(2, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      if (localObject1 == null) {
        break;
      }
      paramView.setImageBitmap((Bitmap)localObject1);
      return;
      localEmoticonLinearLayout.setVisibility(0);
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter = new dev(this, 2006);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.b(false);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.d(false);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.c(false);
      }
      localEmoticonLinearLayout.setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
      localEmoticonLinearLayout.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(2, 4);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a();
      ((View)localObject1).setBackgroundColor(-16777216);
      ((View)localObject1).getBackground().setAlpha(178);
      localButton1.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.name != null)
      {
        if (this.jdField_a_of_type_OrgJsonJSONArray == null) {
          this.jdField_a_of_type_OrgJsonJSONArray = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject2 = ClubContentJsonTask.a(this.jdField_a_of_type_OrgJsonJSONArray, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.wordingId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.expiretime);
        localButton1.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.name + (String)localObject2);
        localTextView4.setText((CharSequence)localObject2);
        localTextView3.setText(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.name);
      }
      ((View)localObject1).setVisibility(0);
      localView2.setVisibility(0);
      localView3.setVisibility(8);
      localView1.setVisibility(8);
      continue;
      if (this.q == 3)
      {
        ((View)localObject1).setVisibility(0);
        if (((View)localObject1).getBackground() != null) {
          ((View)localObject1).getBackground().setAlpha(0);
        }
        localObject1 = (EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(39);
        if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.name != null)
        {
          localTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.name);
          if (this.jdField_a_of_type_OrgJsonJSONArray == null) {
            this.jdField_a_of_type_OrgJsonJSONArray = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          localTextView2.setText(ClubContentJsonTask.a(this.jdField_a_of_type_OrgJsonJSONArray, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.wordingId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.expiretime));
        }
        float f = ((EmojiManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        if (QLog.isColorLevel()) {
          QLog.d("BigEmoticonViewBinder", 2, "Ep id=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + ", progress=" + f);
        }
        if (f >= 0.0F)
        {
          localView2.setVisibility(8);
          ((Button)localObject2).setVisibility(8);
          localButton2.setVisibility(8);
          localView1.setVisibility(0);
          localProgressBar.setProgress((int)(f * 100.0F));
        }
        else
        {
          localView1.setVisibility(8);
          localView2.setVisibility(8);
          localButton2.setVisibility(8);
          ((Button)localObject2).setVisibility(0);
        }
      }
    }
    paramView.setImageResource(2130837527);
  }
  
  public static Drawable b(Context paramContext)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130837538);
    paramContext = paramContext.getResources().getDrawable(2130837539);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842913 }, paramContext);
    localStateListDrawable.addState(new int[0], localDrawable);
    return localStateListDrawable;
  }
  
  private void b(View paramView)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131297083);
    TextView localTextView2 = (TextView)paramView.findViewById(2131297084);
    Button localButton = (Button)paramView.findViewById(2131297085);
    ImageView localImageView = (ImageView)paramView.findViewById(2131297052);
    ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(2131297063);
    paramView = paramView.findViewById(2131297086);
    localTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.name);
    localTextView2.setText(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.updateTip);
    localButton.setOnClickListener(this);
    float f = ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(39)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
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
    localImageView.setImageResource(2130837527);
  }
  
  private void b(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter = new dev(this, 2006);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.b(false);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.d(false);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.c(false);
    }
    paramView = (EmoticonLinearLayout)paramView;
    paramView.setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
    paramView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(2, 4);
    int i = paramInt;
    if (this.q == 2) {
      i = paramInt - 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(i);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a();
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.status;
    boolean bool = EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
    if (QLog.isColorLevel()) {
      QLog.d("log_greverye", 2, "func initPkgStatus, status:" + i + ",shouldUpdate:" + bool + ",updateFlag:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.updateFlag + ",emoticonPkg.valid:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.valid);
    }
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
      if (this.q == 4) {}
      for (String str = EmosmUtils.getCoverPath(3, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);; str = EmosmUtils.getCoverPath(4, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))
      {
        File localFile = new File(str);
        try
        {
          if (!localFile.exists()) {
            break label90;
          }
          paramContext = new BitmapDrawable(paramContext.getResources(), str);
          return paramContext;
        }
        catch (OutOfMemoryError paramContext)
        {
          if (!QLog.isColorLevel()) {
            break label90;
          }
          QLog.w("PicEmoticonPanelInfo", 1, "getTabDrawable OOM return null");
        }
      }
    }
    label90:
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
      localObject = (ProgressBar)((View)localObject).findViewById(2131297063);
      if (localObject != null) {
        ((ProgressBar)localObject).post(new ddz(this, (ProgressBar)localObject, paramInt));
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
    int k = 0;
    int j = 0;
    int i;
    switch (this.q)
    {
    default: 
      i = j;
    }
    do
    {
      do
      {
        do
        {
          return i;
          return 1;
          if (this.jdField_a_of_type_JavaUtilList == null) {
            this.jdField_a_of_type_JavaUtilList = a();
          }
          int m = this.jdField_a_of_type_JavaUtilList.size();
          i = k;
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            i = k;
            if (m > 0)
            {
              j = 0 + m / 8;
              i = j;
              if (m % 8 != 0) {
                i = j + 1;
              }
            }
          }
          return i + 1;
          if (this.jdField_a_of_type_JavaUtilList == null) {
            this.jdField_a_of_type_JavaUtilList = a();
          }
          k = this.jdField_a_of_type_JavaUtilList.size();
          i = j;
        } while (this.jdField_a_of_type_JavaUtilList == null);
        i = j;
      } while (k <= 0);
      j = 0 + k / 8;
      i = j;
    } while (k % 8 == 0);
    return j + 1;
  }
  
  public void b()
  {
    View localView = c(0);
    localView.post(new dea(this, localView));
  }
  
  public void c()
  {
    Object localObject = c(0);
    if (localObject != null)
    {
      localObject = (ImageView)((View)localObject).findViewById(2131297052);
      if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0)) {
        ((ImageView)localObject).post(new deb(this, (ImageView)localObject));
      }
    }
  }
  
  public void d()
  {
    if ((this.q == 2) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.hasReadUpdatePage))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.hasReadUpdatePage = true;
      this.jdField_a_of_type_Int = 1;
      ThreadManager.b(new dec(this));
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(39);
    switch (paramView.getId())
    {
    default: 
    case 2131297085: 
    case 2131297056: 
    case 2131297061: 
    case 2131297060: 
      do
      {
        do
        {
          do
          {
            return;
          } while (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null);
          ((EmojiManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, true);
          localObject3 = c(0);
          paramView = (Button)((View)localObject3).findViewById(2131297085);
          localObject2 = (ProgressBar)((View)localObject3).findViewById(2131297063);
          localObject3 = ((View)localObject3).findViewById(2131297086);
          ((View)localObject3).setVisibility(0);
          f = ((EmojiManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
          if (f >= 0.0F)
          {
            paramView.setVisibility(8);
            ((View)localObject3).setVisibility(0);
            ((ProgressBar)localObject2).setProgress((int)(100.0F * f));
          }
          for (;;)
          {
            this.jdField_a_of_type_Int = 0;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_aio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.localVersion, "" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.latestVersion, "");
            return;
            paramView.setVisibility(0);
            ((View)localObject3).setVisibility(8);
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null);
        EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid(), false);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.status == 2))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_withoutpms_more", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_pkg_more_aio", 0, 0, "", "", "", "");
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null);
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.isRecommendation)
      {
        ((EmosmHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_endoffer_click", 0, 0, "", "", "", "");
      }
      paramView = c(0);
      Object localObject2 = (ImageButton)paramView.findViewById(2131297064);
      localObject2 = (Button)paramView.findViewById(2131297060);
      Object localObject3 = (ProgressBar)paramView.findViewById(2131297063);
      paramView = paramView.findViewById(2131297062);
      float f = ((EmojiManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      ((Button)localObject2).setVisibility(8);
      paramView.setVisibility(0);
      ((ProgressBar)localObject3).setProgress((int)(100.0F * f));
      ((EmojiManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, true);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_pkg_download_aio", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) {
      ((EmojiManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    }
    paramView = c(0);
    localObject1 = (Button)paramView.findViewById(2131297060);
    paramView.findViewById(2131297062).setVisibility(8);
    ((Button)localObject1).setVisibility(0);
    this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("QQLite", 0).edit().remove("LAST_ADD_EMO_PACKAGE").commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BigEmoticonViewBinder
 * JD-Core Version:    0.7.0.1
 */