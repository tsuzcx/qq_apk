import com.tencent.mobileqq.videoplatform.api.IRegisterTVideo;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.TVideoPlatformInfo.Builder;

public class allm
  implements IRegisterTVideo
{
  private static void V(int paramInt, String paramString1, String paramString2)
  {
    SuperPlayerSDKMgr.registerTVideoPlatformInfo(new TVideoPlatformInfo.Builder().pkgName("com.tencent.mobileqq").platform(paramInt).sdtfrom(paramString1).appKey(paramString2).build());
  }
  
  public void registerTVideo()
  {
    V(4080303, "v5214", "iByKf/1opZ3QuYe1/mUHSGbs+8vS87m+73ZFi66ZuFDBZtHVYdaP6J/NFAgOKKknS8+K50ri7+NlSg01AkvrssX7/5KOLn9GYHxCOEmjvVxEgt9P6anI6pm7SdKfI4DtS8iW0WgErUhAXUxpAoJyKdh54ET34LXjR4ni/ZrV7lQ/kMyFMeldNpmO+tkBTxeBHCybyv8bryak9oQC8RzkYHufEPcsZdV+KTc2qT46h8JQKOt8GIEy2MULiGy14UJ8twkrRvqNU9h9cEDrmfLbarpw8hZMpgoRRhs/KcsTPDadZSHbb6Pz6xinE/IVn3tiFwlmu9NoouhzQog9PY8Stc0HosPNB4orE/Ef+Cc4s/xDGFRv1YBr/URxsqafNu6IpLcuEhhFxOZVizeQCmJRcthZyFkGOFLhCptw3Lnt7J9hHmT3cImbwGTc+AZWd32xIBPqUooC0Cwo56+wa3FPIvZg1KRoE3UWS0SsxXwk+KQ//jbw7gOuYC/XEV1P34Nh");
    V(4170303, "v5218", "qbzzDHHTRfnSFLJtBEnxtWZTiramJIeXBW2I1l4wepZJBprKMUSBYHMgM4PTgZdBL85uyScbHwWAEhmKEY2tOWfZZ094ZdpSVWROw3x+Wepi1eGP4FPOR7MmPM1ppMvTG4ITvE9M4yfjpC+9EDMuuYJai3D0mZLYhkzU5biwnF8FLTwZdO4d12VO+xCdSKFZUM6rBUQhIwGGncAtp+XtPMlz4bsioqj0wRUjw44Z91It/azy4GH5zedj6YqWRr+i57alsbvhuC2i8xgq/ErK7RT8du9NoHlxBwIBCL/m2UszkHWpzxraik6AkQ3Zq1kxIK2q6rHquKfQRd/ungHcCyiMcYycFxuF1jT3K7RiOh8wq076qC2Gl6TwZSFtllMJpSJ44OgRbfqTixEOGwaGY//1HtyoVOOA9puTL97Apvk+ukgj+YlGuphZco6ePO7gksS7ZB99i6Srj4rsPoE+GpvQKJbPj8s8s8OHtNNDAgg0nmtzKg5e2pvloIhqRdSG");
    V(30301, "v5145", "qD8jLASr2w2QZrWDoMsCsBq1ML8IaN2wONf8aiu50tOwAt0EMzZYjZmUG3wWD2+Iy9EDDpv+YpAPsMb46wLDhhEzks/x1gLR+RBQ7WkcsLsxxiQRnCkm+bPHwjji1gh04+eEI1PhHT0adngUekkWeGRy8f2sdWJAjHjJKiDiDQO4dtoZ+2ZLnMN3HmkDQ3wAjQbsnAQ/7PRnx1fZfodBCiC4ZBRyDUW3BYsvWZhW9ADg4KoBxc5JcyWwDKsbraJ/kE6IAPvYAkYEI+9wGPOx2+j4bZKjNVIH3FXMAeTE7Y31FCZAHax5skELYABnjuw0PPVpIJSvkcJu9Tn3+uNi7VDlLAo9KXCDz0fkJs+oFHD2DRJqUQxA0aJMT6Q01rIphqw58gSE70SNvnRApA9HnLjTARj4rCH1GMY7PEpEWYmRChuwVgN9Z6GLiAZYthb3FwLVFupgzkDsL6T1sTgK1VQ8OZgZMxfJsFLZcSxYwoN7uGSMj9sHMyIVJj/i5+2+");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     allm
 * JD-Core Version:    0.7.0.1
 */