import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.b;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.j;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.l;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.n;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.o;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.im.oidb.articlesummary.articlesummary.PGCPicInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCVideoInfo;

public class mgm
{
  public static void i(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j != null)) {}
    try
    {
      Object localObject;
      switch (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.aSS)
      {
      case 1: 
        paramBaseArticleInfo.mSocialFeedInfo.aSG = 1;
        paramBaseArticleInfo.mTitle = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$b.title;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null) {
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.amM = true;
        }
        try
        {
          paramBaseArticleInfo.mSinglePicture = new URL(((articlesummary.PGCPicInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$b.kX.get(0)).bytes_pic_url.get().toStringUtf8());
          return;
        }
        catch (MalformedURLException paramBaseArticleInfo)
        {
          paramBaseArticleInfo.printStackTrace();
          return;
        }
        catch (IndexOutOfBoundsException paramBaseArticleInfo)
        {
          paramBaseArticleInfo.printStackTrace();
          return;
        }
      case 3: 
        paramBaseArticleInfo.mSocialFeedInfo.aSG = 1;
        paramBaseArticleInfo.mTitle = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.b.title;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null)
        {
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.amM = true;
          localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.b;
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kZ = new ArrayList();
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kZ.add(localObject);
          try
          {
            paramBaseArticleInfo.mSinglePicture = new URL(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.b.pic_url);
            return;
          }
          catch (MalformedURLException paramBaseArticleInfo)
          {
            paramBaseArticleInfo.printStackTrace();
            return;
          }
        }
        break;
      case 4: 
        paramBaseArticleInfo.mSocialFeedInfo.aSG = 3;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null)
        {
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.amM = true;
          if ((paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$b != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$b.kX != null))
          {
            paramBaseArticleInfo.mTitle = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$b.title;
            paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY = new ArrayList();
            localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$b.kX.iterator();
          }
        }
        break;
      case 2: 
      case 5: 
        while (((Iterator)localObject).hasNext())
        {
          articlesummary.PGCPicInfo localPGCPicInfo = (articlesummary.PGCPicInfo)((Iterator)localObject).next();
          SocializeFeedsInfo.n localn = new SocializeFeedsInfo.n();
          localn.pic_url = localPGCPicInfo.bytes_pic_url.get().toStringUtf8();
          localn.aii = localPGCPicInfo.bytes_thumbnail_url.get().toStringUtf8();
          localn.pic_width = localPGCPicInfo.uint32_pic_width.get();
          localn.pic_height = localPGCPicInfo.uint32_pic_height.get();
          localn.pic_md5 = localPGCPicInfo.bytes_pic_md5.get().toStringUtf8();
          localn.aSX = localPGCPicInfo.is_animation.get();
          localn.aij = localPGCPicInfo.bytes_pic_desc.get().toStringUtf8();
          localn.vP = localPGCPicInfo.uint64_gallery_index.get();
          localn.b = new SocializeFeedsInfo.o((articlesummary.PGCVideoInfo)localPGCPicInfo.msg_video_info.get());
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY.add(localn);
          continue;
          paramBaseArticleInfo.mSocialFeedInfo.aSG = 6;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null) {
            paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.amM = true;
          }
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.b != null)
          {
            paramBaseArticleInfo.mTitle = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.b.title;
            paramBaseArticleInfo.mVideoVid = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.b.vid;
          }
          try
          {
            paramBaseArticleInfo.mVideoCoverUrl = new URL(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.b.pic_url);
            return;
          }
          catch (MalformedURLException paramBaseArticleInfo)
          {
            paramBaseArticleInfo.printStackTrace();
            return;
          }
          paramBaseArticleInfo.mSocialFeedInfo.aSG = 19191924;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null) {
            paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.amM = true;
          }
          paramBaseArticleInfo.mTitle = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$l.title;
          return;
        }
      }
      return;
    }
    catch (NullPointerException paramBaseArticleInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mgm
 * JD-Core Version:    0.7.0.1
 */