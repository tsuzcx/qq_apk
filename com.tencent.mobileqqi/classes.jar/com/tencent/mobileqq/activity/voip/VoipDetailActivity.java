package com.tencent.mobileqq.activity.voip;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.data.voip.VoipHistoryData;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import etn;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class VoipDetailActivity
  extends BaseActivity
  implements Observer
{
  private static float jdField_a_of_type_Float = 2.0F;
  private static int jdField_a_of_type_Int = 3;
  private static VoipContact jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact;
  public static final String a = "VoipDetailActivity";
  private static float jdField_b_of_type_Float = 2.0F;
  public static final String b = "contactId";
  public static final String c = "source";
  public static final String d = "object";
  long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  private VoipHistoryInterface jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface;
  public PhoneContact a;
  public QCallRecent a;
  private VoipHistoryData jdField_a_of_type_ComTencentMobileqqDataVoipVoipHistoryData;
  private PhoneContactManager jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager;
  public HashMap a;
  public List a;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  
  public VoipDetailActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent = null;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  public static Drawable a(Bitmap paramBitmap)
  {
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int[] arrayOfInt1 = new int[j * k];
    int[] arrayOfInt2 = new int[j * k];
    Bitmap localBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
    paramBitmap.getPixels(arrayOfInt1, 0, j, 0, 0, j, k);
    int i = 0;
    while (i < jdField_a_of_type_Int)
    {
      a(arrayOfInt1, arrayOfInt2, j, k, jdField_a_of_type_Float);
      a(arrayOfInt2, arrayOfInt1, k, j, jdField_b_of_type_Float);
      i += 1;
    }
    b(arrayOfInt1, arrayOfInt2, j, k, jdField_a_of_type_Float);
    b(arrayOfInt2, arrayOfInt1, k, j, jdField_b_of_type_Float);
    localBitmap.setPixels(arrayOfInt1, 0, j, 0, 0, j, k);
    return new BitmapDrawable(Bitmap.createBitmap(localBitmap, 10, 0, localBitmap.getWidth() - 20, localBitmap.getHeight()));
  }
  
  private void a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = ImageUtil.b(paramBitmap, paramBitmap.getWidth(), paramBitmap.getWidth(), paramBitmap.getHeight());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(a(paramBitmap));
  }
  
  public static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, float paramFloat)
  {
    int i6 = paramInt1 - 1;
    int i8 = (int)paramFloat;
    int j = i8 * 2 + 1;
    int[] arrayOfInt = new int[j * 256];
    int i = 0;
    while (i < j * 256)
    {
      arrayOfInt[i] = (i / j);
      i += 1;
    }
    i = 0;
    int i1 = 0;
    int m;
    int n;
    int k;
    int i2;
    int i3;
    int i4;
    int i5;
    if (i < paramInt2)
    {
      m = 0;
      n = 0;
      j = 0;
      k = 0;
      i2 = -i8;
      while (i2 <= i8)
      {
        i3 = paramArrayOfInt1[(a(i2, 0, paramInt1 - 1) + i1)];
        m += (i3 >> 24 & 0xFF);
        n += (i3 >> 16 & 0xFF);
        j += (i3 >> 8 & 0xFF);
        k += (i3 & 0xFF);
        i2 += 1;
      }
      i2 = i;
      i4 = j;
      i5 = 0;
      j = i2;
      i3 = m;
      i2 = n;
      n = i4;
      m = i5;
      label206:
      if (m < paramInt1)
      {
        paramArrayOfInt2[j] = (arrayOfInt[i3] << 24 | arrayOfInt[i2] << 16 | arrayOfInt[n] << 8 | arrayOfInt[k]);
        i4 = m + i8 + 1;
        if (i4 <= i6) {
          break label416;
        }
        i4 = i6;
      }
    }
    label416:
    for (;;)
    {
      int i7 = m - i8;
      i5 = i7;
      if (i7 < 0) {
        i5 = 0;
      }
      i4 = paramArrayOfInt1[(i4 + i1)];
      i5 = paramArrayOfInt1[(i5 + i1)];
      i3 += (i4 >> 24 & 0xFF) - (i5 >> 24 & 0xFF);
      i2 += ((0xFF0000 & i4) - (0xFF0000 & i5) >> 16);
      n += ((0xFF00 & i4) - (0xFF00 & i5) >> 8);
      m += 1;
      j += paramInt2;
      k += (i4 & 0xFF) - (i5 & 0xFF);
      break label206;
      i += 1;
      i1 += paramInt1;
      break;
      return;
    }
  }
  
  public static void b(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, float paramFloat)
  {
    paramFloat -= (int)paramFloat;
    float f = 1.0F / (1.0F + 2.0F * paramFloat);
    int j = 0;
    int i = 0;
    while (j < paramInt2)
    {
      paramArrayOfInt2[j] = paramArrayOfInt1[0];
      int m = j + paramInt2;
      int k = 1;
      while (k < paramInt1 - 1)
      {
        int i1 = i + k;
        int i3 = paramArrayOfInt1[(i1 - 1)];
        int n = paramArrayOfInt1[i1];
        int i5 = paramArrayOfInt1[(i1 + 1)];
        int i4 = (int)(((i3 >> 24 & 0xFF) + (i5 >> 24 & 0xFF)) * paramFloat);
        int i2 = (int)(((i3 >> 16 & 0xFF) + (i5 >> 16 & 0xFF)) * paramFloat);
        i1 = (int)(((i3 >> 8 & 0xFF) + (i5 >> 8 & 0xFF)) * paramFloat);
        i3 = (int)(((i5 & 0xFF) + (i3 & 0xFF)) * paramFloat);
        i4 = (int)((i4 + (n >> 24 & 0xFF)) * f);
        i2 = (int)((i2 + (n >> 16 & 0xFF)) * f);
        i1 = (int)((i1 + (n >> 8 & 0xFF)) * f);
        paramArrayOfInt2[m] = ((int)((i3 + (n & 0xFF)) * f) | i4 << 24 | i2 << 16 | i1 << 8);
        m += paramInt2;
        k += 1;
      }
      paramArrayOfInt2[m] = paramArrayOfInt1[(paramInt1 - 1)];
      j += 1;
      i += paramInt1;
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a(jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.lookupID);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name != null))
    {
      getSupportActionBar().setTitle(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name);
      return;
    }
    if (jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.uin != null)
    {
      getSupportActionBar().setTitle(ContactUtils.g(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.uin));
      return;
    }
    getSupportActionBar().setTitle(getString(2131563324));
  }
  
  private void n()
  {
    PhoneContact localPhoneContact;
    if ((this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager != null) && (jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.lookupID != null))
    {
      localPhoneContact = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a(jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.lookupID);
      if ((localPhoneContact == null) || (localPhoneContact.photoUri == null)) {}
    }
    try
    {
      a(MediaStore.Images.Media.getBitmap(getContentResolver(), localPhoneContact.photoUri));
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840369);
    }
  }
  
  private void o()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.uin != null)
    {
      Bitmap localBitmap = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.uin, false);
      if (localBitmap != null) {
        a(localBitmap);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840369);
  }
  
  public void a(View paramView)
  {
    super.onBackPressed();
  }
  
  public void b(View paramView)
  {
    QCallRecent localQCallRecent = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent;
    int i;
    String str1;
    if (localQCallRecent != null)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "CallTab_external", "Book_Details", 0, 1, 0, "", "1", "", "");
      i = localQCallRecent.type;
      paramView = null;
      str1 = null;
      if (i != 1006) {
        break label104;
      }
      str1 = localQCallRecent.uin;
    }
    String str2;
    String str3;
    for (;;)
    {
      str2 = localQCallRecent.troopUin;
      str3 = localQCallRecent.displayName;
      if (localQCallRecent.type != 3000) {
        break;
      }
      ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramView, true, true, null);
      return;
      label104:
      paramView = localQCallRecent.uin;
    }
    ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, a(), i, paramView, str3, str1, true, str2, true, true, null, "");
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131234666));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new etn(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131234665));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131234667));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234663));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234662));
    switch (jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.relationship)
    {
    }
    for (;;)
    {
      m();
      return;
      e();
      continue;
      f();
      continue;
      g();
      continue;
      h();
      continue;
      i();
      continue;
      j();
      continue;
      k();
      continue;
      l();
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.deleteObserver(this);
    }
    QCallFacade localQCallFacade = (QCallFacade)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (localQCallFacade != null) {
      localQCallFacade.deleteObserver(this);
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a(jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.lookupID);
    if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.allPhoneNumber);
    }
    n();
    Object localObject1 = new VoipDetailActivity.VoipQQLabel(this, this, ContactUtils.g(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.uin));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(new VoipDetailActivity.VoipPhoneListDivider(getBaseContext()));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(new VoipDetailActivity.VoipPhoneListItem(this, this, ((VoipPhoneNumber)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString));
      i += 1;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.a(jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact).iterator();
    VoipHistoryData localVoipHistoryData;
    String str;
    label269:
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject1 = (VoipHistoryAllType)localIterator.next();
      if (((VoipHistoryAllType)localObject1).type == 0)
      {
        localVoipHistoryData = (VoipHistoryData)((VoipHistoryAllType)localObject1).obj;
        localObject1 = new Date(localVoipHistoryData.startTime);
        str = new SimpleDateFormat("HH:mm").format((Date)localObject1);
        localObject1 = new SimpleDateFormat("mm:ss");
        if (localVoipHistoryData.status == 3)
        {
          localObject1 = getString(2131563317);
          if (localVoipHistoryData.countryCode == null) {
            break label371;
          }
          localObject2 = localVoipHistoryData.countryCode + localVoipHistoryData.phoneNumberWithoutCountry;
          label304:
          if ((localVoipHistoryData.status != 2) && (localVoipHistoryData.status != 3)) {
            break label380;
          }
          i = 0;
        }
      }
    }
    label527:
    for (;;)
    {
      localObject1 = new VoipDetailActivity.VoipHistoryListItem(this, str, i, (String)localObject2, (String)localObject1);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      break;
      localObject1 = ((SimpleDateFormat)localObject1).format(Long.valueOf(localVoipHistoryData.endTime - localVoipHistoryData.startTime));
      break label269;
      label371:
      localObject2 = localVoipHistoryData.phoneNumberWithoutCountry;
      break label304;
      label380:
      if (localVoipHistoryData.status == 0)
      {
        i = 1;
      }
      else
      {
        if (localVoipHistoryData.status == 1)
        {
          i = 2;
          continue;
          if (((VoipHistoryAllType)localObject1).type == 1)
          {
            localObject2 = (QCallRecord)((VoipHistoryAllType)localObject1).obj;
            if (((QCallRecord)localObject2).type == QCallRecord.TYPE_DATE) {
              break;
            }
            if (((QCallRecord)localObject2).isSender()) {
              i = 0;
            }
            for (;;)
            {
              localObject1 = getString(2131559879);
              if (((QCallRecord)localObject2).isVideo()) {
                localObject1 = getString(2131559878);
              }
              if (!((QCallRecord)localObject2).getTalkTimeMinute().equals("")) {
                break label527;
              }
              localObject1 = new VoipDetailActivity.VoipHistoryListItem(this, ((QCallRecord)localObject2).getTime(), i, (String)localObject1, getString(2131563317));
              this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
              break;
              if (((QCallRecord)localObject2).isMissCall()) {
                i = 2;
              } else {
                i = 1;
              }
            }
            localObject1 = new VoipDetailActivity.VoipHistoryListItem(this, ((QCallRecord)localObject2).getTime(), i, (String)localObject1, ((QCallRecord)localObject2).talkTime);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            break;
          }
          if (((VoipHistoryAllType)localObject1).type != 2) {
            break;
          }
          localObject1 = new VoipDetailActivity.VoipHistoryListDivider(this, (String)((VoipHistoryAllType)localObject1).obj);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          break;
          return;
        }
        i = 0;
      }
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    o();
    Object localObject1 = new VoipDetailActivity.VoipQQLabel(this, this, ContactUtils.g(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.uin));
    ((VoipDetailActivity.VoipQQLabel)localObject1).a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.a(jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact).iterator();
    VoipHistoryData localVoipHistoryData;
    String str;
    label158:
    Object localObject2;
    label193:
    int i;
    if (localIterator.hasNext())
    {
      localObject1 = (VoipHistoryAllType)localIterator.next();
      if (((VoipHistoryAllType)localObject1).type == 0)
      {
        localVoipHistoryData = (VoipHistoryData)((VoipHistoryAllType)localObject1).obj;
        localObject1 = new Date(localVoipHistoryData.startTime);
        str = new SimpleDateFormat("HH:mm").format((Date)localObject1);
        localObject1 = new SimpleDateFormat("mm:ss");
        if (localVoipHistoryData.status == 3)
        {
          localObject1 = getString(2131563317);
          if (localVoipHistoryData.countryCode == null) {
            break label260;
          }
          localObject2 = localVoipHistoryData.countryCode + localVoipHistoryData.phoneNumberWithoutCountry;
          if ((localVoipHistoryData.status != 2) && (localVoipHistoryData.status != 3)) {
            break label269;
          }
          i = 0;
        }
      }
    }
    for (;;)
    {
      localObject1 = new VoipDetailActivity.VoipHistoryListItem(this, str, i, (String)localObject2, (String)localObject1);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      break;
      localObject1 = ((SimpleDateFormat)localObject1).format(Long.valueOf(localVoipHistoryData.endTime - localVoipHistoryData.startTime));
      break label158;
      label260:
      localObject2 = localVoipHistoryData.phoneNumberWithoutCountry;
      break label193;
      label269:
      if (localVoipHistoryData.status == 0)
      {
        i = 1;
      }
      else
      {
        if (localVoipHistoryData.status == 1)
        {
          i = 2;
          continue;
          if (((VoipHistoryAllType)localObject1).type == 1)
          {
            localObject2 = (QCallRecord)((VoipHistoryAllType)localObject1).obj;
            if (((QCallRecord)localObject2).type == QCallRecord.TYPE_DATE) {
              break;
            }
            if (((QCallRecord)localObject2).isSender()) {
              i = 0;
            }
            for (;;)
            {
              localObject1 = getString(2131559879);
              if (((QCallRecord)localObject2).isVideo()) {
                localObject1 = getString(2131559878);
              }
              if (!((QCallRecord)localObject2).getTalkTimeMinute().equals("")) {
                break label416;
              }
              localObject1 = new VoipDetailActivity.VoipHistoryListItem(this, ((QCallRecord)localObject2).getTime(), i, (String)localObject1, getString(2131563317));
              this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
              break;
              if (((QCallRecord)localObject2).isMissCall()) {
                i = 2;
              } else {
                i = 1;
              }
            }
            label416:
            localObject1 = new VoipDetailActivity.VoipHistoryListItem(this, ((QCallRecord)localObject2).getTime(), i, (String)localObject1, ((QCallRecord)localObject2).talkTime);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            break;
          }
          if (((VoipHistoryAllType)localObject1).type != 2) {
            break;
          }
          localObject1 = new VoipDetailActivity.VoipHistoryListDivider(this, (String)((VoipHistoryAllType)localObject1).obj);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          break;
          return;
        }
        i = 0;
      }
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a(jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.lookupID);
    if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.allPhoneNumber);
    }
    n();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(new VoipDetailActivity.VoipPhoneListItem(this, this, ((VoipPhoneNumber)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString));
      if (i != this.jdField_a_of_type_JavaUtilList.size() - 1) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(new VoipDetailActivity.VoipPhoneListDivider(getBaseContext()));
      }
      i += 1;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.a(jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact).iterator();
    Object localObject1;
    VoipHistoryData localVoipHistoryData;
    String str;
    label253:
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject1 = (VoipHistoryAllType)localIterator.next();
      if (((VoipHistoryAllType)localObject1).type == 0)
      {
        localVoipHistoryData = (VoipHistoryData)((VoipHistoryAllType)localObject1).obj;
        localObject1 = new Date(localVoipHistoryData.startTime);
        str = new SimpleDateFormat("HH:mm").format((Date)localObject1);
        localObject1 = new SimpleDateFormat("mm:ss");
        if (localVoipHistoryData.status == 3)
        {
          localObject1 = getString(2131563317);
          if (localVoipHistoryData.countryCode == null) {
            break label355;
          }
          localObject2 = localVoipHistoryData.countryCode + localVoipHistoryData.phoneNumberWithoutCountry;
          label288:
          if ((localVoipHistoryData.status != 2) && (localVoipHistoryData.status != 3)) {
            break label364;
          }
          i = 0;
        }
      }
    }
    for (;;)
    {
      localObject1 = new VoipDetailActivity.VoipHistoryListItem(this, str, i, (String)localObject2, (String)localObject1);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      break;
      localObject1 = ((SimpleDateFormat)localObject1).format(Long.valueOf(localVoipHistoryData.endTime - localVoipHistoryData.startTime));
      break label253;
      label355:
      localObject2 = localVoipHistoryData.phoneNumberWithoutCountry;
      break label288;
      label364:
      if (localVoipHistoryData.status == 0)
      {
        i = 1;
      }
      else
      {
        if (localVoipHistoryData.status == 1)
        {
          i = 2;
          continue;
          if (((VoipHistoryAllType)localObject1).type == 1)
          {
            localObject2 = (QCallRecord)((VoipHistoryAllType)localObject1).obj;
            if (((QCallRecord)localObject2).type == QCallRecord.TYPE_DATE) {
              break;
            }
            if (((QCallRecord)localObject2).isSender()) {
              i = 0;
            }
            for (;;)
            {
              localObject1 = getString(2131559879);
              if (((QCallRecord)localObject2).isVideo()) {
                localObject1 = getString(2131559878);
              }
              if (!((QCallRecord)localObject2).getTalkTimeMinute().equals("")) {
                break label511;
              }
              localObject1 = new VoipDetailActivity.VoipHistoryListItem(this, ((QCallRecord)localObject2).getTime(), i, (String)localObject1, getString(2131563317));
              this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
              break;
              if (((QCallRecord)localObject2).isMissCall()) {
                i = 2;
              } else {
                i = 1;
              }
            }
            label511:
            localObject1 = new VoipDetailActivity.VoipHistoryListItem(this, ((QCallRecord)localObject2).getTime(), i, (String)localObject1, ((QCallRecord)localObject2).talkTime);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            break;
          }
          if (((VoipHistoryAllType)localObject1).type != 2) {
            break;
          }
          localObject1 = new VoipDetailActivity.VoipHistoryListDivider(this, (String)((VoipHistoryAllType)localObject1).obj);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          break;
          return;
        }
        i = 0;
      }
    }
  }
  
  public void h()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.a(jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact).iterator();
    Object localObject;
    VoipHistoryData localVoipHistoryData;
    String str2;
    label111:
    String str1;
    label146:
    int i;
    if (localIterator.hasNext())
    {
      localObject = (VoipHistoryAllType)localIterator.next();
      if (((VoipHistoryAllType)localObject).type == 0)
      {
        localVoipHistoryData = (VoipHistoryData)((VoipHistoryAllType)localObject).obj;
        localObject = new Date(localVoipHistoryData.startTime);
        str2 = new SimpleDateFormat("HH:mm").format((Date)localObject);
        localObject = new SimpleDateFormat("mm:ss");
        if (localVoipHistoryData.status == 3)
        {
          localObject = getString(2131563317);
          if (localVoipHistoryData.countryCode == null) {
            break label213;
          }
          str1 = localVoipHistoryData.countryCode + localVoipHistoryData.phoneNumberWithoutCountry;
          if ((localVoipHistoryData.status != 2) && (localVoipHistoryData.status != 3)) {
            break label222;
          }
          i = 0;
        }
      }
    }
    for (;;)
    {
      localObject = new VoipDetailActivity.VoipHistoryListItem(this, str2, i, str1, (String)localObject);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      break;
      localObject = ((SimpleDateFormat)localObject).format(Long.valueOf(localVoipHistoryData.endTime - localVoipHistoryData.startTime));
      break label111;
      label213:
      str1 = localVoipHistoryData.phoneNumberWithoutCountry;
      break label146;
      label222:
      if (localVoipHistoryData.status == 0)
      {
        i = 1;
      }
      else
      {
        if (localVoipHistoryData.status == 1)
        {
          i = 2;
          continue;
          if (((VoipHistoryAllType)localObject).type != 2) {
            break;
          }
          localObject = new VoipDetailActivity.VoipHistoryListDivider(this, (String)((VoipHistoryAllType)localObject).obj);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
          break;
          return;
        }
        i = 0;
      }
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    o();
    Object localObject = new VoipDetailActivity.VoipQQLabel(this, this, ContactUtils.g(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.uin));
    ((VoipDetailActivity.VoipQQLabel)localObject).a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.a(jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact).iterator();
    while (localIterator.hasNext())
    {
      localObject = (VoipHistoryAllType)localIterator.next();
      if (((VoipHistoryAllType)localObject).type == 1)
      {
        QCallRecord localQCallRecord = (QCallRecord)((VoipHistoryAllType)localObject).obj;
        if (localQCallRecord.type != QCallRecord.TYPE_DATE)
        {
          int i;
          if (localQCallRecord.isSender()) {
            i = 0;
          }
          for (;;)
          {
            localObject = getString(2131559879);
            if (localQCallRecord.isVideo()) {
              localObject = getString(2131559878);
            }
            if (!localQCallRecord.getTalkTimeMinute().equals("")) {
              break label209;
            }
            localObject = new VoipDetailActivity.VoipHistoryListItem(this, localQCallRecord.getTime(), i, (String)localObject, getString(2131563317));
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
            break;
            if (localQCallRecord.isMissCall()) {
              i = 2;
            } else {
              i = 1;
            }
          }
          label209:
          localObject = new VoipDetailActivity.VoipHistoryListItem(this, localQCallRecord.getTime(), i, (String)localObject, localQCallRecord.talkTime);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
        }
      }
      else if (((VoipHistoryAllType)localObject).type == 2)
      {
        localObject = new VoipDetailActivity.VoipHistoryListDivider(this, (String)((VoipHistoryAllType)localObject).obj);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      }
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    getSupportActionBar().setTitle(this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.displayName);
    o();
    Object localObject = new VoipDetailActivity.VoipQQLabel(this, this, this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.displayName);
    ((VoipDetailActivity.VoipQQLabel)localObject).a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.a(jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact).iterator();
    while (localIterator.hasNext())
    {
      localObject = (VoipHistoryAllType)localIterator.next();
      if (((VoipHistoryAllType)localObject).type == 1)
      {
        QCallRecord localQCallRecord = (QCallRecord)((VoipHistoryAllType)localObject).obj;
        if (localQCallRecord.type != QCallRecord.TYPE_DATE)
        {
          int i;
          if (localQCallRecord.isSender()) {
            i = 0;
          }
          for (;;)
          {
            localObject = getString(2131559879);
            if (localQCallRecord.isVideo()) {
              localObject = getString(2131559878);
            }
            if (!localQCallRecord.getTalkTimeMinute().equals("")) {
              break label217;
            }
            localObject = new VoipDetailActivity.VoipHistoryListItem(this, localQCallRecord.getTime(), i, (String)localObject, getString(2131563317));
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
            break;
            if (localQCallRecord.isMissCall()) {
              i = 2;
            } else {
              i = 1;
            }
          }
          label217:
          localObject = new VoipDetailActivity.VoipHistoryListItem(this, localQCallRecord.getTime(), i, (String)localObject, localQCallRecord.talkTime);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
        }
      }
      else if (((VoipHistoryAllType)localObject).type == 2)
      {
        localObject = new VoipDetailActivity.VoipHistoryListDivider(this, (String)((VoipHistoryAllType)localObject).obj);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      }
    }
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a(jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.lookupID);
    if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.allPhoneNumber);
    }
    n();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(new VoipDetailActivity.VoipPhoneListItem(this, this, ((VoipPhoneNumber)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString));
      if (i != this.jdField_a_of_type_JavaUtilList.size() - 1) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(new VoipDetailActivity.VoipPhoneListDivider(getBaseContext()));
      }
      i += 1;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.a(jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact).iterator();
    Object localObject;
    VoipHistoryData localVoipHistoryData;
    String str2;
    label245:
    String str1;
    if (localIterator.hasNext())
    {
      localObject = (VoipHistoryAllType)localIterator.next();
      if (((VoipHistoryAllType)localObject).type == 0)
      {
        localVoipHistoryData = (VoipHistoryData)((VoipHistoryAllType)localObject).obj;
        localObject = new Date(localVoipHistoryData.startTime);
        str2 = new SimpleDateFormat("HH:mm").format((Date)localObject);
        localObject = new SimpleDateFormat("mm:ss");
        if (localVoipHistoryData.status == 3)
        {
          localObject = getString(2131563317);
          if (localVoipHistoryData.countryCode == null) {
            break label347;
          }
          str1 = localVoipHistoryData.countryCode + localVoipHistoryData.phoneNumberWithoutCountry;
          label280:
          if ((localVoipHistoryData.status != 2) && (localVoipHistoryData.status != 3)) {
            break label356;
          }
          i = 0;
        }
      }
    }
    for (;;)
    {
      localObject = new VoipDetailActivity.VoipHistoryListItem(this, str2, i, str1, (String)localObject);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      break;
      localObject = ((SimpleDateFormat)localObject).format(Long.valueOf(localVoipHistoryData.endTime - localVoipHistoryData.startTime));
      break label245;
      label347:
      str1 = localVoipHistoryData.phoneNumberWithoutCountry;
      break label280;
      label356:
      if (localVoipHistoryData.status == 0)
      {
        i = 1;
      }
      else
      {
        if (localVoipHistoryData.status == 1)
        {
          i = 2;
          continue;
          if (((VoipHistoryAllType)localObject).type != 2) {
            break;
          }
          localObject = new VoipDetailActivity.VoipHistoryListDivider(this, (String)((VoipHistoryAllType)localObject).obj);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
          break;
          return;
        }
        i = 0;
      }
    }
  }
  
  public void l()
  {
    if ((jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.phoneNumber != null) && (jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.phoneNumber.jdField_a_of_type_JavaLangString != null)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(new VoipDetailActivity.VoipPhoneListItem(this, this, jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.phoneNumber.jdField_a_of_type_JavaLangString));
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.a(jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact).iterator();
    Object localObject;
    VoipHistoryData localVoipHistoryData;
    String str2;
    label157:
    String str1;
    label192:
    int i;
    if (localIterator.hasNext())
    {
      localObject = (VoipHistoryAllType)localIterator.next();
      if (((VoipHistoryAllType)localObject).type == 0)
      {
        localVoipHistoryData = (VoipHistoryData)((VoipHistoryAllType)localObject).obj;
        localObject = new Date(localVoipHistoryData.startTime);
        str2 = new SimpleDateFormat("HH:mm").format((Date)localObject);
        localObject = new SimpleDateFormat("mm:ss");
        if (localVoipHistoryData.status == 3)
        {
          localObject = getString(2131563317);
          if (localVoipHistoryData.countryCode == null) {
            break label259;
          }
          str1 = localVoipHistoryData.countryCode + localVoipHistoryData.phoneNumberWithoutCountry;
          if ((localVoipHistoryData.status != 2) && (localVoipHistoryData.status != 3)) {
            break label268;
          }
          i = 0;
        }
      }
    }
    for (;;)
    {
      localObject = new VoipDetailActivity.VoipHistoryListItem(this, str2, i, str1, (String)localObject);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      break;
      localObject = ((SimpleDateFormat)localObject).format(Long.valueOf(localVoipHistoryData.endTime - localVoipHistoryData.startTime));
      break label157;
      label259:
      str1 = localVoipHistoryData.phoneNumberWithoutCountry;
      break label192;
      label268:
      if (localVoipHistoryData.status == 0)
      {
        i = 1;
      }
      else
      {
        if (localVoipHistoryData.status == 1)
        {
          i = 2;
          continue;
          if (((VoipHistoryAllType)localObject).type != 2) {
            break;
          }
          localObject = new VoipDetailActivity.VoipHistoryListDivider(this, (String)((VoipHistoryAllType)localObject).obj);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
          break;
          return;
        }
        i = 0;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      setContentView(2130904053);
      this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10));
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface = VoipHistoryInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface.addObserver(this);
      paramBundle = (QCallFacade)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      if (paramBundle != null) {
        paramBundle.addObserver(this);
      }
      paramBundle = getIntent();
    } while (!paramBundle.hasExtra("source"));
    Object localObject;
    if (paramBundle.getStringExtra("source").equals("voipAddressBookActivity"))
    {
      localObject = paramBundle.getStringExtra("contactId");
      jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact = new VoipContact(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, null, (String)localObject, null);
      if (jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.uin != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent = new QCallRecent();
        this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin = jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.uin;
        if (jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.relationship != 2) {
          break label594;
        }
        this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type = 1006;
        this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.displayName = jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.contact.name;
      }
    }
    if (paramBundle.getStringExtra("source").equals("VoipHistoryActivity"))
    {
      localObject = (VoipHistoryData)((VoipHistoryAllType)paramBundle.getSerializableExtra("object")).obj;
      if ((((VoipHistoryData)localObject).uin != null) && (((VoipHistoryData)localObject).uin.equals("0"))) {
        ((VoipHistoryData)localObject).uin = null;
      }
      if (((VoipHistoryData)localObject).countryCode == null) {
        break label626;
      }
      jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact = new VoipContact(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((VoipHistoryData)localObject).uin, ((VoipHistoryData)localObject).contactLookupId, ((VoipHistoryData)localObject).countryCode + ((VoipHistoryData)localObject).phoneNumberWithoutCountry);
      label330:
      if (jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.uin != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent = new QCallRecent();
        this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin = jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.uin;
        this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type = 0;
        this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.displayName = ContactUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.uin, true);
      }
    }
    if (paramBundle.getStringExtra("source").equals("VoipHistoryActivity_qqvoice"))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent = new QCallRecent();
      this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin = paramBundle.getStringExtra("uin");
      this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.troopUin = paramBundle.getStringExtra("troop_uin");
      this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type = paramBundle.getIntExtra("uintype", -1);
      this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.displayName = paramBundle.getStringExtra("uinname");
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin;
      if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type != 1006) {
        break label655;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.displayName;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.troopUin;
    }
    for (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin;; this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e = null)
    {
      jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact = new VoipContact(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
      d();
      return;
      label594:
      this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type = 0;
      this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.displayName = ContactUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact.uin, true);
      break;
      label626:
      jdField_a_of_type_ComTencentMobileqqActivityVoipVoipContact = new VoipContact(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((VoipHistoryData)localObject).uin, ((VoipHistoryData)localObject).contactLookupId, ((VoipHistoryData)localObject).phoneNumberWithoutCountry);
      break label330;
      label655:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = null;
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObservable instanceof VoipHistoryInterface)) || ((paramObservable instanceof QCallFacade)))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_JavaUtilList.clear();
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipDetailActivity
 * JD-Core Version:    0.7.0.1
 */