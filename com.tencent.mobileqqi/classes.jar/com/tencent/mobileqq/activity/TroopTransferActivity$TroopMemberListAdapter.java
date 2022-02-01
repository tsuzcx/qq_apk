package com.tencent.mobileqq.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ImageUtil;
import dtp;
import dtr;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TroopTransferActivity$TroopMemberListAdapter
  extends FacePreloadBaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  protected LayoutInflater a;
  public ArrayList a;
  
  public TroopTransferActivity$TroopMemberListAdapter(TroopTransferActivity paramTroopTransferActivity, Context paramContext, ArrayList paramArrayList)
  {
    super(paramContext, paramTroopTransferActivity.b, paramTroopTransferActivity.a, 1, true);
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    int i;
    ArrayList localArrayList;
    int j;
    label71:
    Object localObject;
    if (paramArrayList == null)
    {
      i = 0;
      localArrayList = new ArrayList();
      paramContext = new ArrayList();
      j = 0;
      if (j >= i) {
        break label272;
      }
      localObject = (String)paramArrayList.get(j);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (Pattern.matches("\\d{5,}+\\|+\\d{1,2}", (CharSequence)localObject))) {
        break label125;
      }
    }
    for (;;)
    {
      j += 1;
      break label71;
      i = paramArrayList.size();
      break;
      label125:
      int k = ((String)localObject).indexOf('|');
      String str = ((String)localObject).substring(0, k);
      k = Integer.parseInt(((String)localObject).substring(k + 1));
      if ((!TextUtils.isEmpty(str)) && ((k & 0x1) == 1))
      {
        localObject = new TroopTransferActivity.TroopMemberItem();
        ((TroopTransferActivity.TroopMemberItem)localObject).jdField_a_of_type_Int = 1;
        ((TroopTransferActivity.TroopMemberItem)localObject).jdField_a_of_type_JavaLangString = str;
        ((TroopTransferActivity.TroopMemberItem)localObject).jdField_b_of_type_Int = k;
        localArrayList.add(localObject);
      }
      else if ((!TextUtils.isEmpty(str)) && ((k & 0x0) == 0))
      {
        localObject = new TroopTransferActivity.TroopMemberItem();
        ((TroopTransferActivity.TroopMemberItem)localObject).jdField_a_of_type_Int = 1;
        ((TroopTransferActivity.TroopMemberItem)localObject).jdField_a_of_type_JavaLangString = str;
        ((TroopTransferActivity.TroopMemberItem)localObject).jdField_b_of_type_Int = k;
        paramContext.add(localObject);
      }
    }
    label272:
    if (localArrayList.size() > 0)
    {
      paramArrayList = new TroopTransferActivity.TroopMemberItem();
      paramArrayList.jdField_a_of_type_Int = 0;
      paramArrayList.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilArrayList.add(0, paramArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
    }
    if (paramContext.size() > 0)
    {
      paramArrayList = new TroopTransferActivity.TroopMemberItem();
      paramArrayList.jdField_a_of_type_Int = 0;
      paramArrayList.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilArrayList.add(paramArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramContext);
    }
    new dtp(this, paramTroopTransferActivity).start();
  }
  
  public TroopTransferActivity.TroopMemberItem a(String paramString)
  {
    Object localObject = null;
    int i = 0;
    if ((localObject == null) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localTroopMemberItem == null) || (!Utils.a(localTroopMemberItem.jdField_a_of_type_JavaLangString, paramString))) {
        break label61;
      }
      localObject = localTroopMemberItem;
    }
    label61:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  protected Object a(int paramInt)
  {
    TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)getItem(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    if (localTroopMemberItem != null) {
      localFaceInfo.jdField_a_of_type_JavaLangString = localTroopMemberItem.jdField_a_of_type_JavaLangString;
    }
    return localFaceInfo;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        localObject1 = (TroopTransferActivity.TroopMemberItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)getItem(paramInt);
    if ((localTroopMemberItem != null) && (localTroopMemberItem.jdField_a_of_type_Int == 0)) {
      return 0;
    }
    if ((localTroopMemberItem != null) && (localTroopMemberItem.jdField_a_of_type_Int == 1)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)getItem(paramInt);
    if (i == 0) {
      if (paramView == null)
      {
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903270, paramViewGroup, false);
        paramView = new dtr(null);
        paramView.c = null;
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup);
        paramViewGroup.setTag(paramView);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem = localTroopMemberItem;
        if ((localTroopMemberItem == null) || (localTroopMemberItem.jdField_b_of_type_Int != 1)) {
          break label135;
        }
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131561620);
      }
    }
    label256:
    for (;;)
    {
      if ((paramView != null) && (paramView.jdField_a_of_type_AndroidWidgetTextView != null)) {
        paramViewGroup.setContentDescription(paramView.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      return paramViewGroup;
      Object localObject = (dtr)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      break;
      label135:
      if ((localTroopMemberItem != null) && (localTroopMemberItem.jdField_b_of_type_Int == 0))
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131562506);
      }
      else
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText("");
        continue;
        if (i == 1)
        {
          if (paramView == null)
          {
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904038, paramViewGroup, false);
            paramView.findViewById(2131234626).setVisibility(8);
            paramView.findViewById(2131234627).setVisibility(8);
            paramViewGroup = new dtr(null);
            paramViewGroup.c = ((ImageView)paramView.findViewById(2131231567));
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231410));
            paramView.setTag(paramViewGroup);
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem = localTroopMemberItem;
            if (localTroopMemberItem == null) {
              break label345;
            }
            localObject = localTroopMemberItem.jdField_a_of_type_JavaLangString;
            label274:
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("0"))) {
              break label351;
            }
            paramViewGroup.c.setImageDrawable(ImageUtil.a());
            label302:
            if (localTroopMemberItem == null) {
              break label377;
            }
          }
          label345:
          label351:
          label377:
          for (localObject = localTroopMemberItem.jdField_b_of_type_JavaLangString;; localObject = "")
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
            localObject = paramView;
            paramView = paramViewGroup;
            paramViewGroup = (ViewGroup)localObject;
            break;
            paramViewGroup = (dtr)paramView.getTag();
            break label256;
            localObject = null;
            break label274;
            paramViewGroup.jdField_a_of_type_JavaLangString = ((String)localObject);
            paramViewGroup.c.setImageBitmap(a(1, localTroopMemberItem.jdField_a_of_type_JavaLangString));
            break label302;
          }
        }
        localObject = null;
        paramViewGroup = paramView;
        paramView = (View)localObject;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */