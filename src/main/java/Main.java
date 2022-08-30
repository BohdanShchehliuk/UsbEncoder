import javax.swing.filechooser.FileSystemView;
import javax.usb.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws UsbException, UnsupportedEncodingException {
        UsbServices services = UsbHostManager.getUsbServices();

        List<UsbDevice> usbDeviceList = USBLister.getHubDevices(services.getRootUsbHub());


        UsbConfiguration configuration = usbDeviceList.get(4).getActiveUsbConfiguration();

    }


}
