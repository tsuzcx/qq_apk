import cooperation.wadl.ipc.WadlResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdDownloadStateUtil;", "", "()V", "convertToDownloadState", "", "status", "Lcooperation/wadl/ipc/WadlResult;", "convertYYBStateToAdState", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class uff
{
  public static final uff a = new uff();
  
  public final int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 0;
    case 2: 
      return 3;
    case 4: 
      return 5;
    case 5: 
      return 5;
    case 3: 
      return 4;
    case 6: 
      return 1;
    case 13: 
      return 1;
    }
    return 6;
  }
  
  public final int a(@NotNull WadlResult paramWadlResult)
  {
    Intrinsics.checkParameterIsNotNull(paramWadlResult, "status");
    switch (paramWadlResult.b)
    {
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 8: 
    default: 
      return 0;
    case 4: 
      return 3;
    case 6: 
      return 5;
    case 5: 
      return 4;
    case 10: 
      return 1;
    case 9: 
      return 1;
    }
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uff
 * JD-Core Version:    0.7.0.1
 */