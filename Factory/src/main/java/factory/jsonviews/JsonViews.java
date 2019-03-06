package factory.jsonviews;

public class JsonViews {
	public static interface IHumainMateriel{};
	public static interface IHumainMatiereModule{};
	public static interface IHumainMatiere extends IHumainMatiereModule{};
	public static interface IHumainMatiereMateriel {};
	
	public static interface IHumainModule{};
	public static interface IMatiereModule{};
	public static interface IHumainMatiereMaterielModule{};
	public static interface IHumainMatiereMaterielModulePromo{};
	public static interface IMaterielMatiereModulePromo{};
	public static interface IMatiereModulePromo{};
	public static interface IHumainPromo{};
	public static interface IHumainMatiereModulePromo{};
	
	
	public static interface IMateriel extends IHumainMateriel,IHumainMatiereMaterielModule,IHumainMatiereMaterielModulePromo,IMaterielMatiereModulePromo{};
	
	public static interface IHumain extends IHumainMateriel, IHumainMatiereModule, IHumainMatiere,IHumainMatiereMaterielModule,IHumainMatiereMaterielModulePromo,IHumainPromo,IHumainMatiereModulePromo {};
	
	public static interface IMatiere extends IHumainMatiereModule, IHumainMatiere,IHumainMatiereMateriel,IMatiereModule,IHumainMatiereMaterielModule,IHumainMatiereMaterielModulePromo,IMaterielMatiereModulePromo,IMatiereModulePromo,IHumainMatiereModulePromo{};
	
	public static interface IModule extends IHumainMatiereModule, IHumainModule,IMatiereModule,IHumainMatiereMaterielModule,IHumainMatiereMaterielModulePromo,IMaterielMatiereModulePromo,IMatiereModulePromo,IHumainMatiereModulePromo{};
	
	public static interface IPromo extends IHumainMatiereMaterielModulePromo,IMaterielMatiereModulePromo,IMatiereModulePromo,IHumainPromo,IHumainMatiereModulePromo{};
	
}
