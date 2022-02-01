import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.a;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.b;
import com.tencent.mobileqq.ocr.ui.SearchResultViewPagerAdapter.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class akog
  extends BaseAdapter
{
  akog.b jdField_a_of_type_Akog$b;
  akoo jdField_a_of_type_Akoo = new akoo();
  QQAppInterface mApp;
  WeakReference<Context> mContext;
  List<akog.a> mItemList = new ArrayList();
  View.OnClickListener mOnClickListener = new akoh(this);
  
  public akog(Context paramContext, QQAppInterface paramQQAppInterface, akog.b paramb)
  {
    this.mContext = new WeakReference(paramContext);
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Akog$b = paramb;
  }
  
  public void a(SearchResultViewPagerAdapter.a parama, List<OCRTextSearchInfo.a> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(parama, paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(SearchResultViewPagerAdapter.a parama, List<OCRTextSearchInfo.a> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    int i;
    label68:
    OCRTextSearchInfo.a locala;
    Object localObject2;
    if (paramBoolean1)
    {
      if (this.mItemList.size() > 0)
      {
        localObject1 = (akog.a)this.mItemList.get(this.mItemList.size() - 1);
        if (((akog.a)localObject1).type == 5) {
          this.mItemList.remove(localObject1);
        }
      }
      i = 0;
      localObject1 = null;
      if (i >= paramList.size()) {
        break label606;
      }
      locala = (OCRTextSearchInfo.a)paramList.get(i);
      if (parama.groupType != 0) {
        break label666;
      }
      localObject2 = new akog.a();
      ((akog.a)localObject2).type = 3;
      if (!TextUtils.isEmpty(locala.groupName))
      {
        ((akog.a)localObject2).el = locala.groupName;
        ((akog.a)localObject2).groupName = locala.groupName;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      Object localObject3;
      if (locala.cB.size() != 0)
      {
        if ((parama.groupType == 0) && (paramBoolean3))
        {
          if (i != 0)
          {
            localObject3 = new akog.a();
            ((akog.a)localObject3).type = 2;
            this.mItemList.add(localObject3);
          }
          this.mItemList.add(localObject2);
          localObject2 = new akog.a();
          ((akog.a)localObject2).type = 1;
          this.mItemList.add(localObject2);
        }
        int j = 0;
        for (;;)
        {
          if (j < locala.cB.size())
          {
            localObject2 = (OCRTextSearchInfo.b)locala.cB.get(j);
            localObject3 = new akog.a();
            ((akog.a)localObject3).type = 0;
            ((akog.a)localObject3).el = ((OCRTextSearchInfo.b)localObject2).data;
            ((akog.a)localObject3).groupName = locala.groupName;
            ((akog.a)localObject3).groupType = locala.groupType;
            ((akog.a)localObject3).position = j;
            this.mItemList.add(localObject3);
            if (j != locala.cB.size() - 1)
            {
              localObject2 = new akog.a();
              ((akog.a)localObject2).type = 1;
              this.mItemList.add(localObject2);
            }
            j += 1;
            continue;
            this.mItemList.clear();
            break;
          }
        }
      }
      if ((!TextUtils.isEmpty(locala.moreUrl)) && (parama.groupType == 0))
      {
        localObject2 = locala.moreUrl;
        localObject3 = locala.bTQ;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new akog.a();
          ((akog.a)localObject2).type = 1;
          this.mItemList.add(localObject2);
          localObject2 = new akog.a();
          ((akog.a)localObject2).type = 4;
          ((akog.a)localObject2).moreUrl = locala.moreUrl;
          ((akog.a)localObject2).groupName = locala.groupName;
          ((akog.a)localObject2).bTQ = locala.bTQ;
          ((akog.a)localObject2).groupType = locala.groupType;
          ((akog.a)localObject2).hasMore = true;
          this.mItemList.add(localObject2);
          if (localObject1 != null)
          {
            ((akog.a)localObject1).bTQ = locala.bTQ;
            ((akog.a)localObject1).moreUrl = locala.moreUrl;
            ((akog.a)localObject1).groupType = locala.groupType;
            ((akog.a)localObject1).hasMore = true;
          }
        }
      }
      i += 1;
      break label68;
      label606:
      parama = new akog.a();
      parama.type = 1;
      this.mItemList.add(parama);
      if (paramBoolean2)
      {
        parama = new akog.a();
        parama.type = 5;
        this.mItemList.add(parama);
      }
      super.notifyDataSetChanged();
      return;
      label666:
      localObject2 = null;
    }
  }
  
  public void clearItems()
  {
    this.mItemList.clear();
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.mItemList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount())) {
      return null;
    }
    return this.mItemList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((akog.a)this.mItemList.get(paramInt)).type;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((Context)this.mContext.get() == null)
    {
      localObject = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    akog.a locala = (akog.a)this.mItemList.get(paramInt);
    if (locala.type == 0)
    {
      localObject = (akon)this.jdField_a_of_type_Akoo.a(0);
      ((akon)localObject).I(paramViewGroup);
      localObject = ((akon)localObject).a(paramInt, paramView, paramViewGroup, this, locala);
      ((View)localObject).setOnClickListener(this.mOnClickListener);
    }
    for (;;)
    {
      ((View)localObject).setTag(locala);
      paramView = (View)localObject;
      break;
      localObject = paramView;
      if (locala.type == 1) {
        localObject = ((akol)this.jdField_a_of_type_Akoo.a(1)).a(paramInt, paramView, paramViewGroup, this, locala);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public class a
  {
    public String bTQ;
    public Object el;
    public String groupName;
    public int groupType;
    public boolean hasMore;
    public String moreUrl;
    public int position;
    public int type;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(akog.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akog
 * JD-Core Version:    0.7.0.1
 */