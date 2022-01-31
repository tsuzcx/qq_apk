import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ViewHolder;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class dxo
  extends CharDividedFacePreloadBaseAdapter
{
  private String jdField_a_of_type_JavaLangString;
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  public int[] a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  
  public dxo(TroopMemberListActivity paramTroopMemberListActivity)
  {
    super(paramTroopMemberListActivity, paramTroopMemberListActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.h == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.h == 2)) {}
    for (paramTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131561895);; paramTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131561620))
    {
      this.jdField_a_of_type_JavaLangString = paramTroopMemberListActivity;
      return;
    }
  }
  
  private Object[] a(List paramList)
  {
    Object localObject4 = new LinkedHashMap();
    TroopMemberListActivity.ATroopMember localATroopMember;
    try
    {
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label272;
        }
        localATroopMember = (TroopMemberListActivity.ATroopMember)localIterator.next();
        if ((!localATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_Boolean)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.l = localATroopMember.b;
      }
      if (TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity) == 2) {
        break label235;
      }
    }
    finally {}
    Object localObject2;
    label147:
    int i;
    if ((localATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.j)) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.k.contains(localATroopMember.jdField_a_of_type_JavaLangString)))
    {
      localObject2 = this.jdField_a_of_type_JavaLangString;
      localObject3 = localObject2;
      if (((String)localObject2).length() == 1)
      {
        i = ((String)localObject2).charAt(0);
        if ((65 > i) || (i > 90)) {
          break label1017;
        }
      }
    }
    label182:
    for (Object localObject3 = ((String)localObject2).toUpperCase();; localObject3 = "#")
    {
      if (((LinkedHashMap)localObject4).get(localObject3) == null) {
        ((LinkedHashMap)localObject4).put(localObject3, new ArrayList());
      }
      ((List)((LinkedHashMap)localObject4).get(localObject3)).add(localATroopMember);
      break;
      label235:
      if ((localATroopMember.c != null) && (localATroopMember.c.length() != 0))
      {
        localObject2 = localATroopMember.c.substring(0, 1);
        break label147;
        paramList = (List)((LinkedHashMap)localObject4).get(this.jdField_a_of_type_JavaLangString);
        label371:
        int j;
        label510:
        int k;
        if (paramList != null)
        {
          i = 0;
          if (i < paramList.size())
          {
            if (((TroopMemberListActivity.ATroopMember)paramList.get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))
            {
              localObject2 = (TroopMemberListActivity.ATroopMember)paramList.get(0);
              paramList.set(0, paramList.get(i));
              paramList.set(i, localObject2);
            }
          }
          else
          {
            i = 0;
            if (i < paramList.size())
            {
              if (!((TroopMemberListActivity.ATroopMember)paramList.get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.j)) {
                break label639;
              }
              if (i != 0)
              {
                if (!((TroopMemberListActivity.ATroopMember)paramList.get(0)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
                  break label633;
                }
                j = 1;
                localObject2 = (TroopMemberListActivity.ATroopMember)paramList.get(j);
                paramList.set(j, paramList.get(i));
                paramList.set(i, localObject2);
              }
            }
            if (!((TroopMemberListActivity.ATroopMember)paramList.get(0)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.j)) {
              break label646;
            }
            i = 1;
            j = paramList.size() - 1;
          }
          for (;;)
          {
            if (j <= i) {
              break label660;
            }
            k = i;
            for (;;)
            {
              if (k < j)
              {
                if (((TroopMemberListActivity.ATroopMember)paramList.get(k)).c.compareToIgnoreCase(((TroopMemberListActivity.ATroopMember)paramList.get(k + 1)).c) > 0)
                {
                  localObject2 = (TroopMemberListActivity.ATroopMember)paramList.get(k);
                  paramList.set(k, paramList.get(k + 1));
                  paramList.set(k + 1, localObject2);
                }
                k += 1;
                continue;
                i += 1;
                break;
                label633:
                j = 0;
                break label443;
                label639:
                i += 1;
                break label371;
                i = 2;
                break label510;
              }
            }
            j -= 1;
          }
        }
        paramList = ((LinkedHashMap)localObject4).keySet().iterator();
        while (paramList.hasNext())
        {
          localObject2 = (String)paramList.next();
          if (!((String)localObject2).equals(this.jdField_a_of_type_JavaLangString)) {
            Collections.sort((List)((LinkedHashMap)localObject4).get(localObject2), new dxt(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, null));
          }
        }
        paramList = new LinkedHashMap();
        if (((LinkedHashMap)localObject4).get(this.jdField_a_of_type_JavaLangString) != null) {
          paramList.put(this.jdField_a_of_type_JavaLangString, ((LinkedHashMap)localObject4).get(this.jdField_a_of_type_JavaLangString));
        }
        for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
          if (((LinkedHashMap)localObject4).get(String.valueOf(c)) != null) {
            paramList.put(String.valueOf(c), ((LinkedHashMap)localObject4).get(String.valueOf(c)));
          }
        }
        if (((LinkedHashMap)localObject4).get("#") != null) {
          paramList.put("#", ((LinkedHashMap)localObject4).get("#"));
        }
        ((LinkedHashMap)localObject4).clear();
        localObject2 = new int[paramList.keySet().size()];
        localObject3 = new String[localObject2.length];
        localObject4 = paramList.keySet().iterator();
        if (localObject2.length == 0) {
          return new Object[0];
        }
        localObject2[0] = 0;
        i = 1;
        while (i < localObject2.length)
        {
          j = localObject2[i];
          k = localObject2[(i - 1)];
          localObject2[i] = (((List)paramList.get(((Iterator)localObject4).next())).size() + k + 1 + j);
          i += 1;
        }
        localObject4 = paramList.keySet().iterator();
        i = 0;
        while (((Iterator)localObject4).hasNext())
        {
          localObject3[i] = ((String)((Iterator)localObject4).next());
          i += 1;
        }
        return new Object[] { paramList, localObject2, localObject3 };
        label1017:
        if ((97 > i) || (i > 122)) {
          continue;
        }
        break label182;
      }
      label443:
      localObject2 = "#";
      break label147;
    }
  }
  
  public int a()
  {
    return 2130903268;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label53;
      }
      if (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  protected Object a(int paramInt)
  {
    TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)getItem(paramInt);
    CharDividedFacePreloadBaseAdapter.FaceInfo localFaceInfo = new CharDividedFacePreloadBaseAdapter.FaceInfo(this);
    if (localATroopMember != null) {
      localFaceInfo.jdField_a_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
    }
    return localFaceInfo;
  }
  
  public void a()
  {
    Object[] arrayOfObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)arrayOfObject[0]);
    this.jdField_a_of_type_ArrayOfInt = ((int[])arrayOfObject[1]);
    this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])arrayOfObject[2]);
    super.notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    if ((this.jdField_a_of_type_ArrayOfJavaLangString.length == 0) && (paramInt < 0))
    {
      ((TextView)paramView).setVisibility(8);
      return;
    }
    ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfInt.length == 0) {
      return 0;
    }
    int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (TroopMemberListActivity.ATroopMember)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    TroopMemberListActivity.ATroopMember localATroopMember;
    if (paramView == null)
    {
      paramView = TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).inflate(2130904036, paramViewGroup, false);
      paramViewGroup = new TroopMemberListActivity.ViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131232618));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231565));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231567));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231411));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131234625));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131234626));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131234623));
      TroopMemberListActivity.ViewHolder.a(paramViewGroup, (Button)paramView.findViewById(2131234627));
      TroopMemberListActivity.ViewHolder.a(paramViewGroup, (RelativeLayout)paramView.findViewById(2131234622));
      TroopMemberListActivity.ViewHolder.a(paramViewGroup, (ShaderAnimLayout)paramView.findViewById(2131230987));
      paramView.setTag(paramViewGroup);
      if (i >= 0) {
        break label820;
      }
      i = -(i + 1) - 1;
      localATroopMember = (TroopMemberListActivity.ATroopMember)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(localATroopMember.jdField_a_of_type_JavaLangString));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(localATroopMember.b);
      paramViewGroup.jdField_a_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
      paramViewGroup.b.setText("");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.h != 1) {
        break label627;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131562357) + paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      TroopMemberListActivity.ViewHolder.a(paramViewGroup).setTag(localATroopMember.jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(localATroopMember.jdField_a_of_type_JavaLangString);
      TroopMemberListActivity.ViewHolder.a(paramViewGroup).setOnClickListener(new dxp(this, localATroopMember));
      if ((TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity) == null) || (localATroopMember.jdField_a_of_type_JavaLangString.equals(TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).ownerUin))) {
        break label576;
      }
      TroopMemberListActivity.ViewHolder.a(paramViewGroup).setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131561927), new Object[] { paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.getText().toString() }));
      TroopMemberListActivity.ViewHolder.a(paramViewGroup).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131561860));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity));
      if ((TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity) == 0L) || (TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity) != Long.parseLong(localATroopMember.jdField_a_of_type_JavaLangString))) {
        break label588;
      }
      TroopMemberListActivity.ViewHolder.a(paramViewGroup).b();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839713);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.c = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      return paramView;
      paramViewGroup = (TroopMemberListActivity.ViewHolder)paramView.getTag();
      break;
      label576:
      TroopMemberListActivity.ViewHolder.a(paramViewGroup).setVisibility(8);
    }
    label588:
    if (TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity) == 0L) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.c = null;
    }
    TroopMemberListActivity.ViewHolder.a(paramViewGroup).c();
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839712);
    return paramView;
    label627:
    if (localATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.j))
    {
      paramViewGroup.b.setText(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131562580));
      paramViewGroup.d.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_Boolean) {
      if ((localATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.j)) || ((!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.j)) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.j != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.k.contains(localATroopMember.jdField_a_of_type_JavaLangString))))
      {
        paramViewGroup.d.clearAnimation();
        paramViewGroup.d.setVisibility(8);
      }
    }
    for (;;)
    {
      paramViewGroup.d.setTag(localATroopMember.jdField_a_of_type_JavaLangString);
      paramViewGroup.d.setOnClickListener(new dxq(this, localATroopMember));
      return paramView;
      paramViewGroup.d.setVisibility(0);
      continue;
      paramViewGroup.d.setVisibility(8);
    }
    label820:
    paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dxo
 * JD-Core Version:    0.7.0.1
 */