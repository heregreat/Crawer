package JD.download;

import JD.domin.Page;

public interface Downloadable {
    Page download(String url);
}
