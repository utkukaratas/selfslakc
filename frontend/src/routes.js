//
// adhoc routing system just enough for our needs.
//

import { writable } from 'svelte/store';
import theRegisteredRoutes from "./registeredRoutes";

export const route = writable({ path: '' });
export const registeredRoutes = theRegisteredRoutes

export function navigate(routeObj) {
  console.assert(routeObj.path in registeredRoutes)

  route.set(routeObj)
}

