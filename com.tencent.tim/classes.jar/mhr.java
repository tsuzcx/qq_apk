import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.NewPackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackArticleInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackQuestionAnswerExtraInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackTopicExtraInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackVideoInfo;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;

public class mhr
{
  public int aHc;
  public int aRX = 6;
  public int aRY;
  public int aRZ;
  public int aSa;
  public String ahm;
  public String ahn;
  public String aho;
  public String ahp;
  public boolean amx = true;
  public boolean amy;
  public UrlJumpInfo f;
  public UrlJumpInfo g;
  public List<mhr.a> iP;
  public String topIconUrl;
  public long uin;
  
  public static mhr a(articlesummary.NewPackInfo paramNewPackInfo)
  {
    try
    {
      mhr localmhr = new mhr();
      localmhr.aRX = paramNewPackInfo.pack_type.get();
      localmhr.topIconUrl = paramNewPackInfo.bytes_top_icon_url.get().toStringUtf8();
      localmhr.ahm = paramNewPackInfo.bytes_top_title.get().toStringUtf8();
      localmhr.ahn = paramNewPackInfo.bytes_more_tips.get().toStringUtf8();
      localmhr.aho = paramNewPackInfo.bytes_more_href.get().toStringUtf8();
      localmhr.ahp = paramNewPackInfo.bytes_sub_head_icon_url.get().toStringUtf8();
      localmhr.aRY = paramNewPackInfo.uin32_head_type.get();
      localmhr.aRZ = paramNewPackInfo.uint32_video_size_type.get();
      localmhr.f = UrlJumpInfo.a((articlesummary.UrlJumpInfo)paramNewPackInfo.msg_head_url_jump_info.get());
      localmhr.g = UrlJumpInfo.a((articlesummary.UrlJumpInfo)paramNewPackInfo.msg_right_more_url_jump_info.get());
      localmhr.aHc = paramNewPackInfo.uint32_column_id.get();
      localmhr.aSa = paramNewPackInfo.uint32_follow_status.get();
      if (paramNewPackInfo.rpt_pack_article_list.has())
      {
        localmhr.iP = new ArrayList();
        paramNewPackInfo = paramNewPackInfo.rpt_pack_article_list.get().iterator();
        while (paramNewPackInfo.hasNext())
        {
          articlesummary.PackArticleInfo localPackArticleInfo = (articlesummary.PackArticleInfo)paramNewPackInfo.next();
          mhr.a locala = new mhr.a();
          locala.articleID = SocializeFeedsInfo.a(localPackArticleInfo.uint64_article_id);
          if (localPackArticleInfo.bytes_article_title.has()) {
            locala.articleTitle = localPackArticleInfo.bytes_article_title.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_article_summary.has()) {
            locala.ahq = localPackArticleInfo.bytes_article_summary.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_first_page_pic_url.has()) {
            locala.ahr = localPackArticleInfo.bytes_first_page_pic_url.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_article_content_url.has()) {
            locala.articleContentUrl = localPackArticleInfo.bytes_article_content_url.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_subscribe_id.has()) {
            locala.subscribeID = localPackArticleInfo.bytes_subscribe_id.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_subscribe_name.has()) {
            locala.subscribeName = localPackArticleInfo.bytes_subscribe_name.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_cell_style_id.has()) {
            locala.aht = localPackArticleInfo.bytes_cell_style_id.get().toStringUtf8();
          }
          if (localPackArticleInfo.uint32_is_first_page_use_gif.has()) {
            locala.aSd = localPackArticleInfo.uint32_is_first_page_use_gif.get();
          }
          if (localPackArticleInfo.uint32_video_comment_count.has()) {
            locala.commentCount = localPackArticleInfo.uint32_video_comment_count.get();
          }
          if (localPackArticleInfo.uint32_video_play_count.has())
          {
            locala.playCount = localPackArticleInfo.uint32_video_play_count.get();
            locala.ahu = muj.bw(locala.playCount);
          }
          if (localPackArticleInfo.bytes_report_common_data.has()) {
            locala.aha = localPackArticleInfo.bytes_report_common_data.get().toStringUtf8();
          }
          locala.algorithmID = SocializeFeedsInfo.a(localPackArticleInfo.uint64_algorithm_id);
          locala.strategyID = SocializeFeedsInfo.a(localPackArticleInfo.uint32_strategy_id);
          if (localPackArticleInfo.bytes_inner_uniq_id.has()) {
            locala.ahs = localPackArticleInfo.bytes_inner_uniq_id.get().toStringUtf8();
          }
          locala.aSb = SocializeFeedsInfo.a(localPackArticleInfo.uint32_is_gallery);
          locala.aSc = SocializeFeedsInfo.a(localPackArticleInfo.uint32_picture_number);
          locala.buttonWording = localPackArticleInfo.bytes_button_wording.get().toStringUtf8();
          if (localPackArticleInfo.msg_pack_feeds_info.has())
          {
            locala.sD = SocializeFeedsInfo.a(localPackArticleInfo.msg_pack_feeds_info.uint64_feeds_id);
            locala.feedsType = SocializeFeedsInfo.a(localPackArticleInfo.msg_pack_feeds_info.uint32_feeds_type);
          }
          Object localObject;
          if (localPackArticleInfo.msg_pack_topic_list_info.has())
          {
            localObject = new mhr.c();
            ((mhr.c)localObject).joinCount = SocializeFeedsInfo.a(localPackArticleInfo.msg_pack_topic_list_info.uint32_join_count);
            ((mhr.c)localObject).ahv = localPackArticleInfo.msg_pack_topic_list_info.bytes_join_wording.get().toStringUtf8();
            ((mhr.c)localObject).topicName = localPackArticleInfo.msg_pack_topic_list_info.bytes_topic_name.get().toStringUtf8();
            ((mhr.c)localObject).aSe = SocializeFeedsInfo.a(localPackArticleInfo.msg_pack_topic_list_info.uint32_topic_id);
            ((mhr.c)localObject).adTag = SocializeFeedsInfo.a(localPackArticleInfo.msg_pack_topic_list_info.uint32_adtag);
            locala.jdField_a_of_type_Mhr$c = ((mhr.c)localObject);
          }
          if (localPackArticleInfo.msg_pack_question_answer_info.has())
          {
            localObject = new mhr.b();
            ((mhr.b)localObject).rowKey = localPackArticleInfo.msg_pack_question_answer_info.bytes_question_rowkey.get().toStringUtf8();
            ((mhr.b)localObject).description = localPackArticleInfo.msg_pack_question_answer_info.bytes_question_desc.get().toStringUtf8();
            locala.jdField_a_of_type_Mhr$b = ((mhr.b)localObject);
          }
          if (localPackArticleInfo.msg_pack_video_info.has())
          {
            localObject = new mhr.d();
            ((mhr.d)localObject).businessType = SocializeFeedsInfo.a(localPackArticleInfo.msg_pack_video_info.uint32_busi_type);
            if (localPackArticleInfo.msg_pack_video_info.bytes_vid.has()) {
              ((mhr.d)localObject).vid = localPackArticleInfo.msg_pack_video_info.bytes_vid.get().toStringUtf8();
            }
            ((mhr.d)localObject).businessType = SocializeFeedsInfo.a(localPackArticleInfo.msg_pack_video_info.uint32_busi_type);
            ((mhr.d)localObject).width = SocializeFeedsInfo.a(localPackArticleInfo.msg_pack_video_info.uint32_width);
            ((mhr.d)localObject).height = SocializeFeedsInfo.a(localPackArticleInfo.msg_pack_video_info.uint32_height);
            ((mhr.d)localObject).duration = SocializeFeedsInfo.a(localPackArticleInfo.msg_pack_video_info.uint32_duration);
            ((mhr.d)localObject).vn = SocializeFeedsInfo.a(localPackArticleInfo.msg_pack_video_info.uint64_file_size);
            ((mhr.d)localObject).vo = SocializeFeedsInfo.a(localPackArticleInfo.msg_pack_video_info.uint64_third_uin);
            if (localPackArticleInfo.msg_pack_video_info.bytes_video_url.has()) {
              ((mhr.d)localObject).ahw = localPackArticleInfo.msg_pack_video_info.bytes_video_url.get().toStringUtf8();
            }
            if (localPackArticleInfo.msg_pack_video_info.bytes_share_url.has()) {
              ((mhr.d)localObject).shareUrl = localPackArticleInfo.msg_pack_video_info.bytes_share_url.get().toStringUtf8();
            }
            if (localPackArticleInfo.msg_pack_video_info.bytes_third_uin_name.has()) {
              ((mhr.d)localObject).thirdUinName = localPackArticleInfo.msg_pack_video_info.bytes_third_uin_name.get().toStringUtf8();
            }
            if (localPackArticleInfo.msg_pack_video_info.bytes_third_name.has()) {
              ((mhr.d)localObject).thirdName = localPackArticleInfo.msg_pack_video_info.bytes_third_name.get().toStringUtf8();
            }
            if (localPackArticleInfo.msg_pack_video_info.bytes_third_icon.has()) {
              ((mhr.d)localObject).thirdIcon = localPackArticleInfo.msg_pack_video_info.bytes_third_icon.get().toStringUtf8();
            }
            if (localPackArticleInfo.msg_pack_video_info.bytes_third_action.has()) {
              ((mhr.d)localObject).thirdAction = localPackArticleInfo.msg_pack_video_info.bytes_third_action.get().toStringUtf8();
            }
            locala.jdField_a_of_type_Mhr$d = ((mhr.d)localObject);
          }
          localmhr.iP.add(locala);
        }
      }
      return localmhr;
    }
    catch (Exception paramNewPackInfo)
    {
      return null;
    }
  }
  
  public byte[] E()
  {
    articlesummary.NewPackInfo localNewPackInfo = new articlesummary.NewPackInfo();
    localNewPackInfo.pack_type.set(this.aRX);
    if (!TextUtils.isEmpty(this.topIconUrl)) {
      localNewPackInfo.bytes_top_icon_url.set(ByteStringMicro.copyFromUtf8(this.topIconUrl));
    }
    if (!TextUtils.isEmpty(this.ahm)) {
      localNewPackInfo.bytes_top_title.set(ByteStringMicro.copyFromUtf8(this.ahm));
    }
    if (!TextUtils.isEmpty(this.ahn)) {
      localNewPackInfo.bytes_more_tips.set(ByteStringMicro.copyFromUtf8(this.ahn));
    }
    if (!TextUtils.isEmpty(this.aho)) {
      localNewPackInfo.bytes_more_href.set(ByteStringMicro.copyFromUtf8(this.aho));
    }
    if (!TextUtils.isEmpty(this.ahp)) {
      localNewPackInfo.bytes_sub_head_icon_url.set(ByteStringMicro.copyFromUtf8(this.ahp));
    }
    localNewPackInfo.uin32_head_type.set(this.aRY);
    localNewPackInfo.uint32_video_size_type.set(this.aRZ);
    localNewPackInfo.uint32_column_id.set(this.aHc);
    if (this.aSa != 0) {
      localNewPackInfo.uint32_follow_status.set(this.aSa);
    }
    if (this.f != null) {
      localNewPackInfo.msg_head_url_jump_info.set(this.f.a());
    }
    if (this.g != null) {
      localNewPackInfo.msg_right_more_url_jump_info.set(this.g.a());
    }
    if (this.iP != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.iP.iterator();
      while (localIterator.hasNext())
      {
        mhr.a locala = (mhr.a)localIterator.next();
        articlesummary.PackArticleInfo localPackArticleInfo = new articlesummary.PackArticleInfo();
        localPackArticleInfo.uint64_article_id.set(locala.articleID);
        if (!TextUtils.isEmpty(locala.articleTitle)) {
          localPackArticleInfo.bytes_article_title.set(ByteStringMicro.copyFromUtf8(locala.articleTitle));
        }
        if (!TextUtils.isEmpty(locala.ahq)) {
          localPackArticleInfo.bytes_article_summary.set(ByteStringMicro.copyFromUtf8(locala.ahq));
        }
        if (!TextUtils.isEmpty(locala.ahr)) {
          localPackArticleInfo.bytes_first_page_pic_url.set(ByteStringMicro.copyFromUtf8(locala.ahr));
        }
        if (!TextUtils.isEmpty(locala.articleContentUrl)) {
          localPackArticleInfo.bytes_article_content_url.set(ByteStringMicro.copyFromUtf8(locala.articleContentUrl));
        }
        if (!TextUtils.isEmpty(locala.subscribeID)) {
          localPackArticleInfo.bytes_subscribe_id.set(ByteStringMicro.copyFromUtf8(locala.subscribeID));
        }
        if (!TextUtils.isEmpty(locala.subscribeName)) {
          localPackArticleInfo.bytes_subscribe_name.set(ByteStringMicro.copyFromUtf8(locala.subscribeName));
        }
        if (!TextUtils.isEmpty(locala.aht)) {
          localPackArticleInfo.bytes_cell_style_id.set(ByteStringMicro.copyFromUtf8(locala.aht));
        }
        localPackArticleInfo.uint64_algorithm_id.set(locala.algorithmID);
        localPackArticleInfo.uint32_strategy_id.set(locala.strategyID);
        if (!TextUtils.isEmpty(locala.ahs)) {
          localPackArticleInfo.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(locala.ahs));
        }
        localPackArticleInfo.uint32_video_play_count.set(locala.playCount);
        localPackArticleInfo.uint32_video_comment_count.set(locala.commentCount);
        if (!TextUtils.isEmpty(locala.aha)) {
          localPackArticleInfo.bytes_report_common_data.set(ByteStringMicro.copyFromUtf8(locala.aha));
        }
        localPackArticleInfo.uint32_is_gallery.set(locala.aSb);
        localPackArticleInfo.uint32_picture_number.set(locala.aSc);
        Object localObject1 = new articlesummary.PackFeedsInfo();
        ((articlesummary.PackFeedsInfo)localObject1).uint64_feeds_id.set(locala.sD);
        ((articlesummary.PackFeedsInfo)localObject1).uint32_feeds_type.set(locala.feedsType);
        Object localObject2;
        if (locala.jdField_a_of_type_Mhr$c != null)
        {
          localObject2 = new articlesummary.PackTopicExtraInfo();
          if (!TextUtils.isEmpty(locala.jdField_a_of_type_Mhr$c.ahv)) {
            ((articlesummary.PackTopicExtraInfo)localObject2).bytes_join_wording.set(ByteStringMicro.copyFromUtf8(locala.jdField_a_of_type_Mhr$c.ahv));
          }
          if (!TextUtils.isEmpty(locala.jdField_a_of_type_Mhr$c.topicName)) {
            ((articlesummary.PackTopicExtraInfo)localObject2).bytes_topic_name.set(ByteStringMicro.copyFromUtf8(locala.jdField_a_of_type_Mhr$c.topicName));
          }
          ((articlesummary.PackTopicExtraInfo)localObject2).uint32_join_count.set(locala.jdField_a_of_type_Mhr$c.joinCount);
          ((articlesummary.PackTopicExtraInfo)localObject2).uint32_topic_id.set(locala.jdField_a_of_type_Mhr$c.aSe);
          ((articlesummary.PackTopicExtraInfo)localObject2).uint32_adtag.set(locala.jdField_a_of_type_Mhr$c.adTag);
          localPackArticleInfo.msg_pack_topic_list_info.set((MessageMicro)localObject2);
        }
        if (locala.jdField_a_of_type_Mhr$b != null)
        {
          localObject2 = new articlesummary.PackQuestionAnswerExtraInfo();
          if (!TextUtils.isEmpty(locala.jdField_a_of_type_Mhr$b.rowKey)) {
            ((articlesummary.PackQuestionAnswerExtraInfo)localObject2).bytes_question_rowkey.set(ByteStringMicro.copyFromUtf8(locala.jdField_a_of_type_Mhr$b.rowKey));
          }
          if (!TextUtils.isEmpty(locala.jdField_a_of_type_Mhr$b.description)) {
            ((articlesummary.PackQuestionAnswerExtraInfo)localObject2).bytes_question_desc.set(ByteStringMicro.copyFromUtf8(locala.jdField_a_of_type_Mhr$b.description));
          }
          localPackArticleInfo.msg_pack_question_answer_info.set((MessageMicro)localObject2);
        }
        localPackArticleInfo.bytes_button_wording.set(ByteStringMicro.copyFromUtf8(locala.buttonWording));
        localPackArticleInfo.msg_pack_feeds_info.set((MessageMicro)localObject1);
        if (locala.jdField_a_of_type_Mhr$d != null)
        {
          localObject1 = new articlesummary.PackVideoInfo();
          ((articlesummary.PackVideoInfo)localObject1).uint32_busi_type.set(locala.jdField_a_of_type_Mhr$d.businessType);
          if (!TextUtils.isEmpty(locala.jdField_a_of_type_Mhr$d.vid)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_vid.set(ByteStringMicro.copyFromUtf8(locala.jdField_a_of_type_Mhr$d.vid));
          }
          ((articlesummary.PackVideoInfo)localObject1).uint32_width.set(locala.jdField_a_of_type_Mhr$d.width);
          ((articlesummary.PackVideoInfo)localObject1).uint32_height.set(locala.jdField_a_of_type_Mhr$d.height);
          ((articlesummary.PackVideoInfo)localObject1).uint32_duration.set(locala.jdField_a_of_type_Mhr$d.duration);
          ((articlesummary.PackVideoInfo)localObject1).uint64_file_size.set(locala.jdField_a_of_type_Mhr$d.vn);
          if (!TextUtils.isEmpty(locala.jdField_a_of_type_Mhr$d.ahw)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_video_url.set(ByteStringMicro.copyFromUtf8(locala.jdField_a_of_type_Mhr$d.ahw));
          }
          if (!TextUtils.isEmpty(locala.jdField_a_of_type_Mhr$d.shareUrl)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_share_url.set(ByteStringMicro.copyFromUtf8(locala.jdField_a_of_type_Mhr$d.shareUrl));
          }
          ((articlesummary.PackVideoInfo)localObject1).uint64_third_uin.set(locala.jdField_a_of_type_Mhr$d.vo);
          if (!TextUtils.isEmpty(locala.jdField_a_of_type_Mhr$d.thirdUinName)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_third_uin_name.set(ByteStringMicro.copyFromUtf8(locala.jdField_a_of_type_Mhr$d.thirdUinName));
          }
          if (!TextUtils.isEmpty(locala.jdField_a_of_type_Mhr$d.thirdName)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_third_name.set(ByteStringMicro.copyFromUtf8(locala.jdField_a_of_type_Mhr$d.thirdName));
          }
          if (!TextUtils.isEmpty(locala.jdField_a_of_type_Mhr$d.thirdIcon)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_third_icon.set(ByteStringMicro.copyFromUtf8(locala.jdField_a_of_type_Mhr$d.thirdIcon));
          }
          if (!TextUtils.isEmpty(locala.jdField_a_of_type_Mhr$d.thirdAction)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_third_action.set(ByteStringMicro.copyFromUtf8(locala.jdField_a_of_type_Mhr$d.thirdAction));
          }
          localPackArticleInfo.msg_pack_video_info.set((MessageMicro)localObject1);
        }
        localArrayList.add(localPackArticleInfo);
      }
      localNewPackInfo.rpt_pack_article_list.set(localArrayList);
    }
    return localNewPackInfo.toByteArray();
  }
  
  public String toString()
  {
    String str = "NewpolymericInfo uin = " + this.uin + " polymericType = " + this.aRX + "\n";
    Object localObject = str;
    if (this.iP != null)
    {
      localObject = str;
      if (!this.iP.isEmpty())
      {
        localObject = this.iP.iterator();
        while (((Iterator)localObject).hasNext())
        {
          mhr.a locala = (mhr.a)((Iterator)localObject).next();
          str = str + locala;
        }
        localObject = str;
      }
    }
    return localObject;
  }
  
  public static class a
    implements Cloneable
  {
    public mhr.b a;
    public mhr.c a;
    public mhr.d a;
    public int aSb;
    public int aSc;
    public int aSd;
    public String aha;
    public String ahq;
    public String ahr;
    public String ahs;
    public String aht;
    public String ahu;
    public long algorithmID;
    public String articleContentUrl;
    public long articleID;
    public String articleTitle;
    public String buttonWording;
    public int commentCount;
    public int feedsType;
    public boolean isUgc;
    public int playCount;
    public long sD;
    public int strategyID;
    public String subscribeID;
    public String subscribeName;
    
    public Object clone()
      throws CloneNotSupportedException
    {
      try
      {
        locala = (a)super.clone();
        QLog.e("NewPolymericInfo", 2, "PackArticleInfo item clone failed. exception = " + localCloneNotSupportedException1);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1)
      {
        try
        {
          if (this.jdField_a_of_type_Mhr$d != null) {
            locala.jdField_a_of_type_Mhr$d = ((mhr.d)this.jdField_a_of_type_Mhr$d.clone());
          }
          if (this.jdField_a_of_type_Mhr$c != null) {
            locala.jdField_a_of_type_Mhr$c = ((mhr.c)this.jdField_a_of_type_Mhr$c.clone());
          }
          if (this.jdField_a_of_type_Mhr$b != null) {
            locala.jdField_a_of_type_Mhr$b = ((mhr.b)this.jdField_a_of_type_Mhr$b.clone());
          }
          return locala;
        }
        catch (CloneNotSupportedException localCloneNotSupportedException2)
        {
          a locala;
          break label76;
        }
        localCloneNotSupportedException1 = localCloneNotSupportedException1;
        locala = null;
      }
      label76:
      return locala;
    }
    
    public String toString()
    {
      return "PackArticleInfo = {\ncellStyleID = " + this.aht + "\narticleID = " + this.articleID + "\narticleTitle = " + this.articleTitle + "\narticleSummary = " + this.ahq + "\nfirstPagePicUrl = " + this.ahr + "\narticleContentUrl = " + this.articleContentUrl + "\nsubscribeID = " + this.subscribeID + "\nsubscribeName = " + this.subscribeName + "\nstrategyID = " + this.strategyID + "\nalgorithmID = " + this.algorithmID + "\nfeedsID = " + this.sD + "\nfeedsType = " + this.feedsType + "\ninnerUniqID = " + this.ahs + "\nisGallery = " + this.aSb + "\ngalleryPicNum = " + this.aSc + "\nvideoInfo = " + this.jdField_a_of_type_Mhr$d + "\nbuttonWording = " + this.buttonWording + "\nisUgc = " + this.isUgc + "\nplayCount=" + this.playCount + "commentCount=" + this.commentCount + "isGifCoverUrl = " + this.aSd + "\n";
    }
  }
  
  public static class b
    implements Cloneable
  {
    public String description;
    public String rowKey;
    
    protected Object clone()
      throws CloneNotSupportedException
    {
      try
      {
        b localb = (b)super.clone();
        return localb;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        QLog.e("NewPolymericInfo", 2, "PackTopicExtraInfo item clone failed. exception = " + localCloneNotSupportedException);
      }
      return null;
    }
  }
  
  public static class c
    implements Cloneable
  {
    public int aSe;
    public int adTag;
    public String ahv;
    public int joinCount;
    public String topicName;
    
    protected Object clone()
      throws CloneNotSupportedException
    {
      try
      {
        c localc = (c)super.clone();
        return localc;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        QLog.e("NewPolymericInfo", 2, "PackTopicExtraInfo item clone failed. exception = " + localCloneNotSupportedException);
      }
      return null;
    }
  }
  
  public static class d
    implements Cloneable
  {
    public String ahw;
    public int businessType;
    public int duration;
    public int height;
    public String shareUrl;
    public String thirdAction;
    public String thirdIcon;
    public String thirdName;
    public String thirdUinName;
    public String vid;
    public long vn;
    public long vo;
    public int width;
    
    protected Object clone()
      throws CloneNotSupportedException
    {
      try
      {
        d locald = (d)super.clone();
        return locald;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        QLog.e("NewPolymericInfo", 2, "PackVideoInfo item clone failed. exception = " + localCloneNotSupportedException);
      }
      return null;
    }
    
    public String toString()
    {
      return "PackVideoInfo{businessType=" + this.businessType + ", vid='" + this.vid + '\'' + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", xgFileSize=" + this.vn + ", thirdUrl='" + this.ahw + '\'' + ", shareUrl='" + this.shareUrl + '\'' + ", thirdUin=" + this.vo + ", thirdUinName='" + this.thirdUinName + '\'' + ", thirdName='" + this.thirdName + '\'' + ", thirdIcon='" + this.thirdIcon + '\'' + ", thirdAction='" + this.thirdAction + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mhr
 * JD-Core Version:    0.7.0.1
 */