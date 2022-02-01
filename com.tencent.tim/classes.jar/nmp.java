import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.ModuleInfo;
import tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.TextCardInfo;

public class nmp
{
  private static int a(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2, List<BaseData> paramList)
  {
    int m = 0;
    if ((paramList == null) || (paramList.isEmpty())) {
      paramInt1 = -1;
    }
    label134:
    label143:
    label149:
    label208:
    for (;;)
    {
      return paramInt1;
      int i;
      int k;
      int j;
      if (paramBoolean1)
      {
        i = 0;
        k = 1;
        j = i;
        Object localObject = (BaseData)paramList.get(j);
        i = k;
        if (!(localObject instanceof ProteusItemData)) {
          break label149;
        }
        localObject = (ProteusItemData)localObject;
        i = k;
        if (((ProteusItemData)localObject).mModuleType != 1) {
          break label149;
        }
        if (((ProteusItemData)localObject).bad != paramInt2)
        {
          i = k;
          if (paramInt2 != 0) {
            break label149;
          }
        }
        if (paramInt1 != k) {
          break label143;
        }
        if (!paramBoolean2) {
          break label134;
        }
        label109:
        paramInt2 = 1;
        paramInt1 = j;
      }
      for (;;)
      {
        label114:
        if (paramInt2 != 0) {
          break label208;
        }
        return -1;
        i = paramList.size() - 1;
        break;
        j += 1;
        break label109;
        i = k + 1;
        if (paramBoolean1) {
          j += 1;
        }
        for (;;)
        {
          if (j >= 0)
          {
            if (j >= paramList.size())
            {
              paramInt1 = i;
              paramInt2 = m;
              break label114;
              j -= 1;
              continue;
            }
            k = i;
            break;
          }
        }
        paramInt1 = i;
        paramInt2 = m;
      }
    }
  }
  
  private static void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, List<BaseData> paramList, ProteusItemData paramProteusItemData)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      do
      {
        return;
        paramInt1 = a(paramBoolean1, paramInt2, paramBoolean2, paramInt1, paramList);
      } while (paramInt1 == -1);
      if ((paramInt1 >= 0) && (paramInt1 < paramList.size()))
      {
        paramList.add(paramInt1, paramProteusItemData);
        return;
      }
    } while (paramInt1 < paramList.size());
    paramList.add(paramProteusItemData);
  }
  
  public static void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, List<BaseData> paramList, List<oidb_cmd0xc6d.ModuleInfo> paramList1, ItemShowDispatcher paramItemShowDispatcher, SparseArray<Float> paramSparseArray)
  {
    if ((paramList == null) || (paramList1 == null)) {}
    for (;;)
    {
      return;
      if (t(paramList))
      {
        QLog.d("FastWeb0xc6dDataUtils", 1, "has inserted module!");
        return;
      }
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramSparseArray = (oidb_cmd0xc6d.ModuleInfo)paramList1.next();
        try
        {
          ProteusItemData localProteusItemData = nmx.a(new JSONObject(paramSparseArray.bytes_json.get().toStringUtf8()), paramArticleInfo, paramFastWebArticleInfo);
          localProteusItemData.mModuleType = -99;
          localProteusItemData.kC = paramSparseArray.bytes_weight.get();
          nnn.a(paramList, localProteusItemData, paramItemShowDispatcher);
        }
        catch (Exception paramSparseArray)
        {
          QLog.d("FastWeb0xc6dDataUtils", 1, "insertModules error! msg=" + paramSparseArray);
        }
      }
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, List<BaseData> paramList, List<oidb_cmd0xc6d.TextCardInfo> paramList1, ItemShowDispatcher paramItemShowDispatcher, SparseArray<Float> paramSparseArray)
  {
    if ((paramList == null) || (paramList1 == null)) {}
    for (;;)
    {
      return;
      if (u(paramList))
      {
        QLog.d("FastWeb0xc6dDataUtils", 1, "has inserted text cards!");
        return;
      }
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramItemShowDispatcher = (oidb_cmd0xc6d.TextCardInfo)paramList1.next();
        try
        {
          ProteusItemData localProteusItemData = nmx.a(new JSONObject(paramItemShowDispatcher.bytes_card_json.get().toStringUtf8()), paramArticleInfo, paramFastWebArticleInfo);
          localProteusItemData.mModuleType = 1;
          localProteusItemData.bad = -1;
          localProteusItemData.kC = nmx.a(paramSparseArray);
          a(paramItemShowDispatcher.enum_indexing_type.get(), paramItemShowDispatcher.bool_locate_forwards.get(), paramItemShowDispatcher.uint32_location.get(), paramItemShowDispatcher.bool_insert_forwards.get(), paramList, localProteusItemData);
        }
        catch (Exception paramItemShowDispatcher)
        {
          QLog.d("FastWeb0xc6dDataUtils", 1, "insertTextCards error! msg=" + paramItemShowDispatcher);
        }
      }
    }
  }
  
  private static boolean t(List<BaseData> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseData localBaseData = (BaseData)paramList.next();
      if (((localBaseData instanceof ProteusItemData)) && (((ProteusItemData)localBaseData).mModuleType == -99)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean u(List<BaseData> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseData localBaseData = (BaseData)paramList.next();
      if (((localBaseData instanceof ProteusItemData)) && (((ProteusItemData)localBaseData).bad == -1)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nmp
 * JD-Core Version:    0.7.0.1
 */