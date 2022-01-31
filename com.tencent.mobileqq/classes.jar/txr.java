import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class txr
  extends twq
{
  private VidListPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo;
  private twl jdField_a_of_type_Twl;
  
  public txr(VidListPlayInfo paramVidListPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo = paramVidListPlayInfo;
    this.jdField_a_of_type_Twl = new twl("vidList");
  }
  
  public List<tws> a(List<twl> paramList)
  {
    return null;
  }
  
  public two a()
  {
    return new two(this.jdField_a_of_type_Twl, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mStartVid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mStartVideoFeedId);
  }
  
  public void a() {}
  
  public void a(int paramInt, twr paramtwr)
  {
    ArrayList localArrayList = new ArrayList();
    twm localtwm = new twm(this.jdField_a_of_type_Twl);
    localArrayList.add(localtwm);
    localtwm.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVidList;
    int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVideoFeedIdList.size();
    paramInt = 0;
    if (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVidList.size())
    {
      if (paramInt < i) {}
      for (String str = (String)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVideoFeedIdList.get(paramInt);; str = (String)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVideoFeedIdList.get(i - 1))
      {
        localtwm.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVidList.get(paramInt), str);
        paramInt += 1;
        break;
      }
    }
    paramtwr.b(new ErrorMessage(), localArrayList, true);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txr
 * JD-Core Version:    0.7.0.1
 */