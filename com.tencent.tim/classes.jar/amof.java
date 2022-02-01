import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import pb.unify.search.UnifySearchDiscovery.Result;
import pb.unify.search.UnifySearchDiscovery.SubBusinessItem;
import pb.unite.search.DynamicDiscovery.Result;
import pb.unite.search.DynamicDiscovery.SubBusinessItem;

public class amof
  extends amrb
{
  public List<amof.a> entries = new ArrayList();
  
  public amof(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramInt2, paramBoolean);
  }
  
  public amof(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramArrayOfByte, paramInt2, paramBoolean);
    bu(paramArrayOfByte);
  }
  
  private boolean awb()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchEntryDataModel", 2, "fabricateModel, isFromReadInjoy mTabType= " + this.bms);
    }
    return this.bms == 10;
  }
  
  private void dOo()
  {
    Object localObject1 = null;
    int i = 0;
    Object localObject2 = null;
    Object localObject3;
    if (i < this.entries.size())
    {
      localObject3 = (amof.a)this.entries.get(i);
      if (((amof.a)localObject3).dDd == 1) {
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (((amof.a)localObject3).dDd != 4) {
        if (((amof.a)localObject3).dDd == 3)
        {
          localObject1 = localObject3;
          continue;
          localObject3 = new ArrayList();
          Object localObject4 = new amof.a();
          ((amof.a)localObject4).title = acfp.m(2131703306);
          ((amof.a)localObject4).iconUrl = "https://qzonestyle.gtimg.cn/aoi/sola/20190816141611_NQ31kYWAQJ.png";
          ((amof.a)localObject4).at = new long[0];
          ((amof.a)localObject4).jumpUrl = "mqqapi://contact/search_might_know";
          ((amof.a)localObject4).dDb = 0;
          ((amof.a)localObject4).dDc = 0;
          ((amof.a)localObject4).dDd = 104;
          ((List)localObject3).add(localObject4);
          if (amxh.oL("emoji"))
          {
            localObject4 = amxh.nh("emoji");
            if (QLog.isColorLevel()) {
              QLog.d("SearchEntryDataModel", 2, "fabricateModel, EmojiEntrySwitchOn url= " + (String)localObject4);
            }
            amof.a locala = new amof.a();
            locala.title = acfp.m(2131703318);
            locala.iconUrl = "https://pub.idqqimg.com/pc/misc/files/20190522/88ab43d24bc14de9a48d3ee11471b7ea.png";
            locala.at = new long[0];
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              locala.jumpUrl = ((String)localObject4);
            }
            locala.dDb = 0;
            locala.dDc = 0;
            locala.dDd = 101;
            ((List)localObject3).add(locala);
          }
          if (localObject2 != null)
          {
            ((amof.a)localObject2).iconUrl = "https://pub.idqqimg.com/pc/misc/files/20190522/299abcb70f194aeab89292db649698f5.png";
            if (!aekv.agU()) {
              break label598;
            }
            localObject4 = aekv.tl();
            if (!TextUtils.isEmpty((CharSequence)localObject4))
            {
              ((amof.a)localObject2).jumpUrl = ((String)localObject4);
              MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "expo", "2");
              label330:
              ((List)localObject3).add(localObject2);
            }
          }
          else
          {
            localObject2 = new amof.a();
            ((amof.a)localObject2).title = acfp.m(2131703319);
            ((amof.a)localObject2).iconUrl = "https://qzonestyle.gtimg.cn/aoi/sola/20190529143225_pb7ADOBDqd.png";
            ((amof.a)localObject2).at = new long[0];
            ((amof.a)localObject2).jumpUrl = "mqqapi://miniapp/open?_atype=0&_mappid=1109875297&_mvid=&_vt=3&via=2005_1&_sig=4bf2da5e43a83ba7a9e2446bf338da983e145d8c21ed6e9a3bdcb28c3f125c12";
            ((amof.a)localObject2).dDb = 0;
            ((amof.a)localObject2).dDc = 0;
            ((amof.a)localObject2).dDd = 103;
            ((List)localObject3).add(localObject2);
            if ((localObject1 != null) && (!anwa.aze()))
            {
              ((amof.a)localObject1).iconUrl = "https://pub.idqqimg.com/pc/misc/files/20190522/cd2f6f83d9814d529c5efed2b45dbecd.png";
              ((List)localObject3).add(localObject1);
            }
            if (!amxh.oL("wiki")) {
              break label612;
            }
            localObject1 = amxh.nh("wiki");
            localObject2 = amxh.ni("wiki");
            if (QLog.isColorLevel()) {
              QLog.d("SearchEntryDataModel", 2, "fabricateModel, isWikiEntrySwitchOn wikiUrl= " + (String)localObject1 + ", wikiIconUrl = " + (String)localObject2);
            }
            localObject4 = new amof.a();
            ((amof.a)localObject4).title = acfp.m(2131719302);
            ((amof.a)localObject4).at = new long[0];
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ((amof.a)localObject4).jumpUrl = ((String)localObject1);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              ((amof.a)localObject4).iconUrl = ((String)localObject2);
            }
            ((amof.a)localObject4).dDb = 0;
            ((amof.a)localObject4).dDc = 0;
            ((amof.a)localObject4).dDd = 105;
            ((List)localObject3).add(localObject4);
          }
          for (;;)
          {
            this.entries.clear();
            this.entries.addAll((Collection)localObject3);
            return;
            ((amof.a)localObject2).jumpUrl = "mqqapi://miniapp/open?_atype=0&_mappid=1109740431&_mvid=&_vt=3&referer=2005&via=2005_4&_sig=6ee2c9e5075a2d129ac57b0a38af3fcdab417ff1fef97908d5e4806f94eb44af";
            break;
            label598:
            MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "expo", "1");
            break label330;
            label612:
            localObject1 = new amof.a();
            ((amof.a)localObject1).title = acfp.m(2131703301);
            ((amof.a)localObject1).iconUrl = "https://pub.idqqimg.com/pc/misc/files/20190522/7b5f61f779db42e38d8d8b6757a72e1b.png";
            ((amof.a)localObject1).at = new long[0];
            ((amof.a)localObject1).jumpUrl = "https://h5.qzone.qq.com/qzone/ugcsearch?_wv=17039363&_wwv=1293&_proxy=1";
            ((amof.a)localObject1).dDb = 0;
            ((amof.a)localObject1).dDc = 0;
            ((amof.a)localObject1).dDd = 102;
            ((List)localObject3).add(localObject1);
          }
        }
      }
    }
  }
  
  public void bu(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    int i;
    amof.a locala;
    List localList;
    int j;
    if (!this.cEd)
    {
      localObject = new DynamicDiscovery.Result();
      try
      {
        ((DynamicDiscovery.Result)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((DynamicDiscovery.Result)localObject).sub_business_items.get();
        i = 0;
        while (i < paramArrayOfByte.size())
        {
          localObject = (DynamicDiscovery.SubBusinessItem)paramArrayOfByte.get(i);
          locala = new amof.a();
          locala.title = ((DynamicDiscovery.SubBusinessItem)localObject).title.get().toStringUtf8();
          locala.iconUrl = ((DynamicDiscovery.SubBusinessItem)localObject).icon_url.get().toStringUtf8();
          localList = ((DynamicDiscovery.SubBusinessItem)localObject).group_masks.get();
          locala.at = new long[localList.size()];
          j = 0;
          while (j < localList.size())
          {
            locala.at[j] = ((Long)localList.get(j)).longValue();
            j += 1;
          }
          locala.jumpUrl = ((DynamicDiscovery.SubBusinessItem)localObject).jump_url.get().toStringUtf8();
          locala.dDb = ((DynamicDiscovery.SubBusinessItem)localObject).has_red_dot.get();
          locala.dDc = ((DynamicDiscovery.SubBusinessItem)localObject).red_seq.get();
          locala.dDd = ((DynamicDiscovery.SubBusinessItem)localObject).bzid.get();
          this.entries.add(locala);
          i += 1;
        }
        if (!awb()) {
          dOo();
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SearchEntryDataModel", 2, "fabricateModel, DynamicDiscovery InvalidProtocolBufferMicroException e = " + paramArrayOfByte);
          }
        }
      }
      QLog.d("SearchEntryDataModel818searchProto_old", 2, "fabricateModel");
      return;
    }
    Object localObject = new UnifySearchDiscovery.Result();
    try
    {
      ((UnifySearchDiscovery.Result)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = ((UnifySearchDiscovery.Result)localObject).sub_business_items.get();
      i = 0;
      while (i < paramArrayOfByte.size())
      {
        localObject = (UnifySearchDiscovery.SubBusinessItem)paramArrayOfByte.get(i);
        locala = new amof.a();
        locala.title = ((UnifySearchDiscovery.SubBusinessItem)localObject).title.get().toStringUtf8();
        locala.iconUrl = ((UnifySearchDiscovery.SubBusinessItem)localObject).icon_url.get().toStringUtf8();
        localList = ((UnifySearchDiscovery.SubBusinessItem)localObject).group_masks.get();
        locala.at = new long[localList.size()];
        j = 0;
        while (j < localList.size())
        {
          locala.at[j] = ((Long)localList.get(j)).longValue();
          j += 1;
        }
        locala.jumpUrl = ((UnifySearchDiscovery.SubBusinessItem)localObject).jump_url.get().toStringUtf8();
        locala.dDb = ((UnifySearchDiscovery.SubBusinessItem)localObject).has_red_dot.get();
        locala.dDc = ((UnifySearchDiscovery.SubBusinessItem)localObject).red_seq.get();
        locala.dDd = ((UnifySearchDiscovery.SubBusinessItem)localObject).bzid.get();
        this.entries.add(locala);
        i += 1;
      }
      if (!awb()) {
        dOo();
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SearchEntryDataModel", 2, "fabricateModel, UnifySearchDiscovery InvalidProtocolBufferMicroException e = " + paramArrayOfByte);
        }
      }
    }
    QLog.d("SearchEntryDataModel818searchProto_new", 2, "fabricateModel");
  }
  
  public static class a
  {
    public long[] at;
    public int dDb;
    public int dDc;
    public int dDd;
    public String iconUrl;
    public String jumpUrl;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amof
 * JD-Core Version:    0.7.0.1
 */