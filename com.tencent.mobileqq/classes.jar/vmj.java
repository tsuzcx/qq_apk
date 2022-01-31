import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class vmj
  extends vli
{
  private VidListPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo;
  private vld jdField_a_of_type_Vld;
  
  public vmj(VidListPlayInfo paramVidListPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo = paramVidListPlayInfo;
    this.jdField_a_of_type_Vld = new vld("vidList");
  }
  
  public List<vlk> a(List<vld> paramList)
  {
    return null;
  }
  
  public vlg a()
  {
    return new vlg(this.jdField_a_of_type_Vld, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mStartVid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mStartVideoFeedId);
  }
  
  public void a() {}
  
  public void a(int paramInt, vlj paramvlj)
  {
    ArrayList localArrayList = new ArrayList();
    vle localvle = new vle(this.jdField_a_of_type_Vld);
    localArrayList.add(localvle);
    localvle.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVidList;
    int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVideoFeedIdList.size();
    paramInt = 0;
    if (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVidList.size())
    {
      if (paramInt < i) {}
      for (String str = (String)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVideoFeedIdList.get(paramInt);; str = (String)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVideoFeedIdList.get(i - 1))
      {
        localvle.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVidList.get(paramInt), str);
        paramInt += 1;
        break;
      }
    }
    paramvlj.b(new ErrorMessage(), localArrayList, true);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmj
 * JD-Core Version:    0.7.0.1
 */