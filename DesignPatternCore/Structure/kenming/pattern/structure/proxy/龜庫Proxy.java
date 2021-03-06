package kenming.pattern.structure.proxy;

public class 龜庫Proxy implements I龜庫接口
{
    /// <summary>
    /// 取得所販售烏龜的認證資訊
    /// </summary>
    /// <param name="烏龜品種">烏龜品種</param>
    /// <returns>認證資訊</returns>
    public String Get認證資訊(String m品種, String m序號)
    {
        String 認證資訊;

        // 1. 如果販售的烏龜為保育類 (本例象龜為保育類)
        //    需透過 龜庫Informer 類別連線至總部系統取得認證資訊
        // 2. 若為一般烏龜，則直接從區域端資料庫取得認證資訊
        
        if (m品種.equals("象龜"))
        {
            // new the real-subject instance
            龜庫Informer subject = new 龜庫Informer();
            認證資訊 = subject.Get認證資訊(m品種, m序號);
        }
        else
            認證資訊 = this.查詢認證(m序號);

        return 認證資訊;
    }

    // 透過序號至資料庫系統取得認證資訊
    private String 查詢認證(String m序號)
    {
        // TODO: 需連線至資料庫系統
        String queryResult = "序號:" + m序號 + " 的認證資訊從" + "「區域端資料庫」取得認證結果。";

        return queryResult;
    }
}
