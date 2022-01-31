import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;

class erc
  implements Runnable
{
  erc(erb paramerb, TroopUploadingThread.UploadState paramUploadState) {}
  
  public void run()
  {
    AvatarWallAdapter.m = 0;
    this.jdField_a_of_type_Erb.a.n = 0;
    int i = this.jdField_a_of_type_Erb.a.b - this.jdField_a_of_type_Erb.a.j;
    if (i >= 8) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.a != 1) {
            break;
          }
          this.jdField_a_of_type_Erb.a.a(i, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.c);
        } while (this.jdField_a_of_type_Erb.a.a(this.jdField_a_of_type_Erb.a.g));
        this.jdField_a_of_type_Erb.a.d = false;
        this.jdField_a_of_type_Erb.a.b();
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.a != 2);
      str = this.jdField_a_of_type_Erb.a.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.b);
    } while (str == null);
    this.jdField_a_of_type_Erb.a.a(str, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     erc
 * JD-Core Version:    0.7.0.1
 */