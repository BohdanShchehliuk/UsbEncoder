import javax.usb.UsbDevice;
import javax.usb.UsbException;
import javax.usb.UsbHub;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class USBLister {
    public static List listPeripherique(UsbHub hub) {
        //List all the USBs attached
        List perepheriques = hub.getAttachedUsbDevices();
        Iterator iterator = perepheriques.iterator();

        while (iterator.hasNext()) {

            UsbDevice perepherique = (UsbDevice) iterator.next();
            System.out.println(perepherique);

            if (perepherique.isUsbHub()) {
                listPeripherique((UsbHub) perepherique);
            }
        }
        return null;
    }

    public static List<UsbDevice> getHubDevices(UsbHub hub) throws UnsupportedEncodingException, UsbException {
        ArrayList<UsbDevice> devices = new ArrayList<UsbDevice>();
        @SuppressWarnings("unchecked") List<UsbDevice> children = hub.getAttachedUsbDevices();
        Iterator<UsbDevice> it = children.iterator();
        while (it.hasNext()) {
            UsbDevice child = it.next();
            if (child.isUsbHub()) {
                devices.addAll(getHubDevices((UsbHub) child));
            } else {
                devices.add(child);
            }
        }
        return devices;
    }
}
