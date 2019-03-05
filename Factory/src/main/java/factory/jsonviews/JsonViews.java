package factory.jsonviews;

public class JsonViews {
	public static interface HumainMaterielMatiereModulePromo {

	};

	public static interface HumainMaterielMatiereModule extends HumainMaterielMatiereModulePromo {

	};

	public static interface HumainMaterielMatierePromo extends HumainMaterielMatiereModulePromo {

	};

	public static interface HumainMaterielModulePromo extends HumainMaterielMatiereModulePromo {

	};

	public static interface HumainMatiereModulePromo extends HumainMaterielMatiereModulePromo {

	};

	public static interface MaterielMatiereModulePromo extends HumainMaterielMatiereModulePromo {

	};

	public static interface IMateriel extends HumainMaterielMatiereModule, HumainMaterielMatierePromo,
			HumainMaterielModulePromo, MaterielMatiereModulePromo {

	};

	public static interface IHumain extends HumainMaterielMatiereModule, HumainMaterielMatierePromo,
			HumainMaterielModulePromo, HumainMatiereModulePromo {

	};

	public static interface IMatiere extends HumainMaterielMatiereModule, HumainMaterielMatierePromo,
			HumainMatiereModulePromo, MaterielMatiereModulePromo {

	};
	
	public static interface IModule extends HumainMaterielMatiereModule, HumainMaterielModulePromo, HumainMatiereModulePromo, MaterielMatiereModulePromo{
		
	};
	
	public static interface IPromo extends HumainMaterielMatierePromo, HumainMaterielModulePromo, HumainMatiereModulePromo, MaterielMatiereModulePromo {
		
	};
	
}
